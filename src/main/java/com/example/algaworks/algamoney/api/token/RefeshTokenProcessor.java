package com.example.algaworks.algamoney.api.token;

import org.aspectj.weaver.tools.ISupportsMessageContext;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RefeshTokenProcessor implements ReesposeBodyAdvice<OAuth2AccessToken>{
    @Override
    public boolean supports(MethodParameter returneType, Class<? extends HttpMessageConverter<?>>
            selectedCoverterType, ServerHttpRequest request, ServerHttpResponse response){
            return returneType.getMethod().getName().eguals("postAcessstken");
    }
        beforeBodyWrite(OAuth2AccessToken)
}

