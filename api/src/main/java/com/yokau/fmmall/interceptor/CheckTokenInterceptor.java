package com.yokau.fmmall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yokau.fmmall.vo.ResStatus;
import com.yokau.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");
        if (token == null || token.equals("")) {
            ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录！", null);
            //提示请先登录
            doResponse(response, resultVO);
        } else {
            // 2. 校验token
            try {
                JwtParser parser = Jwts.parser();

                // 解析token的SigningKey必须和生成token时设置的密码一致
                parser.setSigningKey("yokau722900");

                // 如果token正确（密码正确，有效期内）则正常执行，否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);

//                Claims claimsJwsBody = claimsJws.getBody();  //获取token中用户数据
//                String subject = claimsJwsBody.getSubject(); //获取生成token设置的subject
//                Object value1 = claimsJwsBody.get("key1", String.class);  //获取生成token时存储的Claims的map中的值

                ResultVO resultVO = new ResultVO(ResStatus.OK, "success", null);
                doResponse(response, resultVO);
                return true;
            }catch (ExpiredJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "登录过期，请重新登录！", null);
                doResponse(response, resultVO);
            }catch (UnsupportedJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "Token非法，请自重！", null);
                doResponse(response, resultVO);
            }catch (Exception e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "请重新登录", null);
                doResponse(response, resultVO);
            }

        }
        return false;

    }
    private void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.print(s);
        out.flush();
        out.close();
    }
}
