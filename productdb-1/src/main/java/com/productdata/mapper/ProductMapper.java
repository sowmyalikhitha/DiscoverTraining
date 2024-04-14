package com.productdata.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.productdata.eo.ProductEo;
import com.productdata.vo.ProductVo;

@Mapper
public interface ProductMapper {	
	
	ProductVo EotoVo(ProductEo producteo);
	ProductEo VotoEo(ProductVo productvo);
	List<ProductVo> EotoVoList(List<ProductEo> productEos);
}
