package pl.bnsit.account;

import static com.google.common.collect.Iterables.filter;
import static java.util.Arrays.asList;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import pl.bnsit.account.details.DetailsForm;
import pl.bnsit.account.details.DetailsListener;
import pl.bnsit.account.details.DetailsPresenter;
import pl.bnsit.account.details.DetailsView;
import pl.bnsit.account.details.DetailsViewObserver;
import pl.bnsit.account.main.MainWindow;

import com.google.common.base.Predicate;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class DefaultGuiceModule extends AbstractModule {

	private EventBus eventBus = new EventBus("default-event-bus");

	@Override
	protected void configure() {

		bind(MainWindow.class);

		bind(DetailsPresenter.class);
		
		bind(DetailsListener.class);

		bind(DetailsView.class).to(DetailsForm.class);

		bind(DetailsViewObserver.class).to(DetailsPresenter.class);

		bind(EventBus.class).toInstance(eventBus);

		bindListener(Matchers.any(), new TypeListener() {
			public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
				encounter.register(new PostConstructAnnotationListener<I>());
			}
		});

		bindListener(Matchers.any(), new TypeListener() {
			public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
				encounter.register(new RegisterSubscribersListener<I>());
			}
		});
	}

	private class RegisterSubscribersListener<I> implements
			InjectionListener<I> {
		public void afterInjection(I i) {
			eventBus.register(i);
		}
	}

	private class PostConstructAnnotationListener<I> implements
			InjectionListener<I> {
		@Override
		public void afterInjection(final I injectee) {
			for (final Method postConstructMethod : filter(asList(injectee
					.getClass().getMethods()), new PostConstructPredicate())) {
				try {
					postConstructMethod.invoke(injectee);
				} catch (final Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		private class PostConstructPredicate implements Predicate<Method> {
			public boolean apply(Method input) {
				return input.isAnnotationPresent(PostConstruct.class);
			}
		}
	}
}
