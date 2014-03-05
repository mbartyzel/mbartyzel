package pl.bnsit.onepieceflow.card;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.google.inject.Inject;

public class CardFormEventHandler implements MouseListener, MouseMotionListener {

	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int mouseX = 0;
	private volatile int mouseY = 0;

	@Inject
	private CardViewObserver viewObserver;
	
	@Inject
	private CardView view;

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		screenX = e.getXOnScreen();
		screenY = e.getYOnScreen();

		mouseX = view.getX();
		mouseY = view.getY();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int deltaX = e.getXOnScreen() - screenX;
        int deltaY = e.getYOnScreen() - screenY;

        view.draggAndDropp( mouseX + deltaX, mouseY + deltaY );
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
