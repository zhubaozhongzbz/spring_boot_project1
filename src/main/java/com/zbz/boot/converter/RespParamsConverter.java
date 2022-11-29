package com.zbz.boot.converter;

import com.zbz.boot.bean.Pet;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class RespParamsConverter implements Converter<String, Pet> {


    @Override
    public Pet convert(String source) {
        if(StringUtils.hasLength(source)){
            Pet pet=new Pet();
            String[]  splits=source.split(",");
            pet.setName(splits[0]);
            return pet;
        }
        return null;
    }
}
