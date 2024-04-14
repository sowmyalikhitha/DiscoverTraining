package com.productdata.mapper;

import com.productdata.eo.ProductEo;
import com.productdata.vo.ProductVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-13T13:36:23+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Eclipse Adoptium)"
)

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductVo EotoVo(ProductEo producteo) {
        if ( producteo == null ) {
            return null;
        }

        ProductVo productVo = new ProductVo();

        productVo.setId( producteo.getId() );
        productVo.setName( producteo.getName() );
        productVo.setPrice( producteo.getPrice() );

        return productVo;
    }

    @Override
    public ProductEo VotoEo(ProductVo productvo) {
        if ( productvo == null ) {
            return null;
        }

        ProductEo productEo = new ProductEo();

        productEo.setId( productvo.getId() );
        productEo.setName( productvo.getName() );
        productEo.setPrice( productvo.getPrice() );

        return productEo;
    }

    @Override
    public List<ProductVo> EotoVoList(List<ProductEo> productEos) {
        if ( productEos == null ) {
            return null;
        }

        List<ProductVo> list = new ArrayList<ProductVo>( productEos.size() );
        for ( ProductEo productEo : productEos ) {
            list.add( EotoVo( productEo ) );
        }

        return list;
    }
}
