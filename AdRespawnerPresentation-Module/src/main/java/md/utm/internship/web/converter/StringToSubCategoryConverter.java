package md.utm.internship.web.converter;

import org.springframework.core.convert.converter.Converter;

import md.utm.internship.rest.client.domain.SubCategory;
import md.utm.internship.web.service.CategoryMvcService;

public class StringToSubCategoryConverter implements Converter<String, SubCategory> {

	private CategoryMvcService categoryService;
	
	public StringToSubCategoryConverter(CategoryMvcService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public SubCategory convert(String source) {
		String[] splitted = source.split("-");
		Long adDomainId = Long.valueOf(splitted[0]);
		Long subCategoryId = Long.valueOf(splitted[1]);
		return categoryService.getSubcategoryById(adDomainId, subCategoryId);
	}
}
