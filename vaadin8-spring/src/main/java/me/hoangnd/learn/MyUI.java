package me.hoangnd.learn;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.spring.annotation.SpringUI;

import java.time.LocalDate;
import java.util.EnumSet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@SpringUI
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Title mr = new Title("MR","Ông");
        Title mrs = new Title("MRS", "Bà");
        Title ms = new Title("MS", "Cô");


        final Person person = new Person();
        person.setFirstName("James");
        person.setLastName("Bond");
        person.setSex(Sex.Male);
        person.setMarital(Marital.SINGLE);
        person.setTitle(mr);
        person.setDateOfBirth(LocalDate.of(1981,1,1));
        final Binder<Person> personBinder = new Binder<>();

        final FormLayout layout = new FormLayout();

        final TextField txtFirstName = new TextField("Tên");
        personBinder.forField(txtFirstName).bind(Person::getFirstName,Person::setFirstName);


        final TextField txtLastName = new TextField("Họ");
        personBinder.forField(txtLastName).bind(Person::getLastName, Person::setLastName);

        ComboBox<Sex> sexComboBox = new ComboBox<>("Giới tính");
        personBinder.forField(sexComboBox).bind(Person::getSex, Person::setSex);
        sexComboBox.setItems(EnumSet.allOf(Sex.class));
        sexComboBox.setEmptySelectionAllowed(false);


        RadioButtonGroup<Marital> optMarital = new RadioButtonGroup<>("Tình trạng hôn nhân");
        personBinder.forField(optMarital).bind(Person::getMarital, Person::setMarital);
        optMarital.setItems(EnumSet.allOf(Marital.class));

        ComboBox<Title> cboTitle = new ComboBox<>("Danh xưng");
        personBinder.forField(cboTitle).bind(Person::getTitle, Person::setTitle);
        cboTitle.setItems(mr, mrs, ms);
        cboTitle.setItemCaptionGenerator(Title::getName);

        DateField dateField = new DateField("Năm sinh");
        personBinder.forField(dateField).bind(Person::getDateOfBirth, Person::setDateOfBirth);
        dateField.setDateFormat("yyyy-MM-dd");


        personBinder.readBean(person);

        layout.addComponents(cboTitle, txtFirstName, txtLastName, sexComboBox, optMarital,dateField);

        Button button = new Button("Lưu");
        button.addClickListener( e -> {
            boolean ok = personBinder.writeBeanIfValid(person);
            if(ok){

                String msg = "fname = " + person.getFirstName() + "\r\n";
                msg  += "lname = " + person.getLastName() + "\r\n";
                msg += "sex=" + person.getSex() + "\r\n";
                msg += "marital=" + person.getMarital() + "\r\n";
                Notification.show("Thông tin",msg, Notification.Type.HUMANIZED_MESSAGE);

            }
        });

        layout.addComponents(button);
        
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponent(layout);
        setContent(mainLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }


}
