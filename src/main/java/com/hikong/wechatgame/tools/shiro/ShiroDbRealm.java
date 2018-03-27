package com.hikong.wechatgame.tools.shiro;

import com.hikong.wechatgame.admin.domain.SysRole;
import com.hikong.wechatgame.admin.domain.User;
import com.hikong.wechatgame.admin.service.LearnUserService;
import com.hikong.wechatgame.admin.service.SysRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroDbRealm extends AuthorizingRealm {
    @Autowired
    private LearnUserService userService;
    @Autowired
    private SysRoleService sysRoleService;
    //权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String loginName = (String)super.getAvailablePrincipal(principals);
        User user = userService.queryLearnUserByUserName(loginName);
        if(user != null){
            //权限信息对象info,用来存放查出的用户的所有角色及权限
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //info.setRoles(sysRoleService.getRolesNamesByUserId(user.getId()));
            List<SysRole> sysRoles = sysRoleService.getRolesByUserId(user.getId());
            for (SysRole role : sysRoles){
                info.addStringPermissions(sysRoleService.getNodeNameslByRoleId(role.getId()));
            }
            return info;
        }
        return null;
    }
    //登陆验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = null;
        // 1. 把AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        // 2. 从UsernamePasswordToken中获取email
        String username = upToken.getUsername();
        // 3. 若用户不存在，抛出UnknownAccountException异常
        user = userService.queryLearnUserByUserName(upToken.getUsername());
        if (user == null)
            throw new UnknownAccountException("用户不存在！");
        // 4. 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        // 以下信息从数据库中获取
        // （1）principal：认证的实体信息，可以是email，也可以是数据表对应的用户的实体类对象
        Object principal = username;
        // （2）credentials：密码
        Object credentials = user.getPassword();
        // （3）realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        // （4）盐值：取用户信息中唯一的字段来生成盐值，避免由于两个用户原始密码相同，加密后的密码也相同
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,
                realmName);

        doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        return info;
    }
}
