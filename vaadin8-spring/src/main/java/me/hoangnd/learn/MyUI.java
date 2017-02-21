package me.hoangnd.learn;


import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import me.hoangnd.learn.view.DefaultView;
import me.hoangnd.learn.view.PersonView;

@Theme("mytheme")
@SpringUI
public class MyUI extends UI implements ViewDisplay {

    
   
	private static final long serialVersionUID = 1L;

	@Autowired
    SpringNavigator navigator;
    
    private Panel springViewDisplay;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        this.navigator.init(this, (ViewDisplay)this);
        
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(false);
        mainLayout.setSpacing(false);
        
        
        springViewDisplay = new Panel();
        springViewDisplay.setSizeFull();
        
        HorizontalLayout navLayout = new HorizontalLayout();
        navLayout.setMargin(false);
        navLayout.setSpacing(false);
        navLayout.addComponent(new Button("Trang chủ", (event) -> {
            getUI().getNavigator().navigateTo(DefaultView.VIEW_NAME);
        }));
        navLayout.addComponent(new Button("Nhân viên", (event) -> {
            getUI().getNavigator().navigateTo(PersonView.VIEW_NAME);
        }));
        
        mainLayout.addComponent(navLayout);
        mainLayout.addComponent(springViewDisplay);
        mainLayout.setExpandRatio(springViewDisplay, 1.0f);
        
        
        setContent(mainLayout);
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }
}
