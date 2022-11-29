package com.zbz.boot.config;

import com.zbz.boot.bean.Pet;
import com.zbz.boot.converter.RespParamsConverter;
import com.zbz.boot.converter.ZbzMessageConverter;
import com.zbz.boot.interceptor.RedisCountInterceptor;
import com.zbz.boot.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Configuration(proxyBeanMethods=true)
public class WebConfig {
    //更改表单的传入method的方式
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    @Bean
   public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            /**filter和interceptor 几乎拥有同样的功能
             *filter是servlet的原生组件，脱离spring也可以使用；
             * interceptor 是spring定义的接口，可以使用自动装配；
             */
            @Autowired
            RedisCountInterceptor countInterceptor;
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")//拦截静态和所有强求都会被拦截
                        .excludePathPatterns("/","/login","/css/**","/js/**","/fonts/**","/images/**");//放行
                //这里countInterceptor不能new,需要注入，因为有依赖StringRedisTomplat的注入；
                registry.addInterceptor(countInterceptor).addPathPatterns("/**")
                        .excludePathPatterns("/","/login","/css/**","/js/**","/fonts/**","/images/**");;
            }
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                WebMvcConfigurer.super.configurePathMatch(configurer);
            }
            //配置入参  converter"aaa,12" 转换成Pet

            @Override
            public void addFormatters(FormatterRegistry registry) {
                Converter<String,Pet> converter=strpet->{
                    if(StringUtils.hasLength(strpet)){
                        Pet pet=new Pet();
                        String[] split=strpet.split(",");
                        pet.setName(split[0]);
                        return  pet;
                    }
                    return null;
                };

//                registry.addConverter(converter);
                  registry.addConverter(new RespParamsConverter());
//                registry.addConverter((String strpet)->{
//                    if (!StringUtils.isEmpty(strpet) ) {
//                        Pet pet=new Pet();
//                        String[] split=strpet.split(",");
//                        pet.setName(split[0]);
//                        return  pet;
//                    }
//
 //               });

            }

//            @Override
//            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//               // WebMvcConfigurer.super.configureContentNegotiation(configurer);
//                //Map<String, MediaType> mediaTypes
//                Map<String, MediaType> mediaTypes = new HashMap<>();
//                mediaTypes.put("json",MediaType.APPLICATION_JSON);
//                mediaTypes.put("xml", MediaType.APPLICATION_XML);
//                //自定义媒体类型
//                mediaTypes.put("zbz",MediaType.parseMediaType("application/x-zbz"));
//                //指定支持解析哪些参数对应的哪些媒体类型
//                ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
//                //                parameterStrategy.setParameterName("ff");
//
//                //还需添加请求头处理策略，否则accept:application/json、application/xml则会失效
//                HeaderContentNegotiationStrategy headeStrategy = new HeaderContentNegotiationStrategy();
//
//                configurer.strategies(Arrays.asList(parameterStrategy, headeStrategy));
//
//            }

            @Override
            public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
                WebMvcConfigurer.super.configureAsyncSupport(configurer);
            }

            @Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
            }


            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                WebMvcConfigurer.super.addResourceHandlers(registry);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                WebMvcConfigurer.super.addViewControllers(registry);
            }

            @Override
            public void configureViewResolvers(ViewResolverRegistry registry) {
                WebMvcConfigurer.super.configureViewResolvers(registry);
            }

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
                WebMvcConfigurer.super.addArgumentResolvers(resolvers);
            }

            @Override
            public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
                WebMvcConfigurer.super.addReturnValueHandlers(handlers);
            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                WebMvcConfigurer.super.configureMessageConverters(converters);
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

                converters.add(new ZbzMessageConverter());
            }

            @Override
            public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
                WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
            }

            @Override
            public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
                WebMvcConfigurer.super.extendHandlerExceptionResolvers(resolvers);
            }

            @Override
            public Validator getValidator() {
                return WebMvcConfigurer.super.getValidator();
            }

            @Override
            public MessageCodesResolver getMessageCodesResolver() {
                return WebMvcConfigurer.super.getMessageCodesResolver();
            }
        };
   }

}
