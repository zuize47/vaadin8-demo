package me.hoangnd.learn.view;

import com.vaadin.ui.*;

import me.hoangnd.learn.MyUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import javax.annotation.PostConstruct;

@SpringView(name = DefaultView.VIEW_NAME, ui = MyUI.class)
public class DefaultView extends VerticalLayout implements View {
    
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "";

    @PostConstruct
    void init() {
        addComponent(new Label("Đây là trang chủ"));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}