package pl.bnsit.onepieceflow;

import static com.google.common.collect.Iterables.filter;
import static java.util.Arrays.asList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.bnsit.onepieceflow.card.CardForm;
import pl.bnsit.onepieceflow.card.CardListener;
import pl.bnsit.onepieceflow.card.CardPresenter;
import pl.bnsit.onepieceflow.card.CardView;
import pl.bnsit.onepieceflow.card.CardViewObserver;

import com.google.common.base.Predicate;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class DefaultGuiceModule extends AbstractModule {

	private EventBus eventBus = new EventBus("main-event-bus");

	@Override
	protected void configure() {

		bind(CardListener.class);
		bind(CardView.class).to(CardForm.class);
		bind(CardViewObserver.class).to(CardPresenter.class);
		
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
	
	public static void runAndShowForm(Class<? extends JPanel> clazz) {
		Injector injector = Guice.createInjector(new DefaultGuiceModule());

		JPanel form = injector.getInstance(clazz);
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(form, BorderLayout.CENTER);
		centerJFrame(frame);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void centerJFrame(JFrame f) {
		Toolkit toolkit = f.getToolkit();
		Dimension size = toolkit.getScreenSize();
		Point location = new Point(	size.width/2 - f.getWidth()/2, 
				size.height/2 - f.getHeight()/2);
		f.setLocation(location);
	}
}
