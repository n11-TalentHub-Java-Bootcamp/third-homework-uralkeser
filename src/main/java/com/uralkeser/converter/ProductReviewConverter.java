package com.uralkeser.converter;

import com.uralkeser.dto.ProductReviewDto;
import com.uralkeser.entity.ProductReview;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductReviewConverter {
    ProductReviewConverter INSTANCE = Mappers.getMapper(ProductReviewConverter.class);

    ProductReview convertProductReviewDtoToProductReview(ProductReviewDto productReviewDto);

    ProductReviewDto convertProductReviewToProductReviewDto(ProductReview productReview);

    List<ProductReviewDto> convertProductReviewListToProductReviewDtoList(List<ProductReview> productReviewList);
}
