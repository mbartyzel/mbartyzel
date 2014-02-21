package pl.bnsit.account.details;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;

public class DetailsPresenter implements DetailsViewObserver {

	private DynaBean viewModel;
	
	@Inject
	private DetailsView view;
	
	@Inject
	private EventBus eventBus;
	
	@PostConstruct
	public void buildViewModel() {
		viewModel = new LazyDynaBean();
		viewModel.set("email", "other@riverside.com");
		viewModel.set("login", "coolquy");
	}
	
	@Override
	public void updateViewModel(String property, Object value) {
		viewModel.set(property, value);
	}
	
	public void updateView() {
		view.updateComponent("email", viewModel.get("email"));
		view.updateComponent("login", viewModel.get("login"));
	}

	@Override
	public void viewIsReady() {
		updateView();
	}
}
