package service;

import java.util.List;
import entity.Option;

public interface IOptionService {
	public List<Option> getAll();

	public Option getOptionById(Long optionId);

	public void deleteOptionById(Long optionId);
}
