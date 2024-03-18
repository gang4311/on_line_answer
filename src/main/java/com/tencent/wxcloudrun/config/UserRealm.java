package com.tencent.wxcloudrun.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencent.wxcloudrun.common.UserTypeEnum;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        /**配置权限
         *此处User实体需配置属性roles，用户权限
         *获取当前用户对象
         * */
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        User currentUser =(User) subject.getPrincipal();
        authorizationInfo.addStringPermission(UserTypeEnum.getMsgByCode(Integer.valueOf(currentUser.getType())));
        log.info("用户权限为："+currentUser.getType());
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //用户名/密码认证
        //从接口处获取得到的用户名
        String username = token.getUsername();
        //调用mybatis_plus中的方法，查询数据库中用户名对应的数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name",username);
        User user=userMapper.selectOne(wrapper);
        //为空，即用户名不存在
        if(user==null){
            return null;
        }else {
            log.info(user.getName());
        }
        //principal：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
        Object principal = user.getName();
        return  new SimpleAuthenticationInfo(user, user.getPassword() , ByteSource.Util.bytes(principal),getName());
    }
}
