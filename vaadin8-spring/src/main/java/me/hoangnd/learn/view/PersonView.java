/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hoangnd.learn.view;

import com.vaadin.data.Binder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;

import me.hoangnd.learn.MyUI;
import me.hoangnd.learn.bean.Marital;
import me.hoangnd.learn.bean.Person;
import me.hoangnd.learn.bean.Sex;
import me.hoangnd.learn.bean.Title;

import java.time.LocalDate;
import java.util.EnumSet;

/**
 *
 * @author hoang
 */
@SpringView(name = PersonView.VIEW_NAME,ui = MyUI.class)
@UIScope
public class PersonView extends FormLayout implements View{
    public final static String VIEW_NAME="personview";

    public PersonView() {
        buildGUI();
    }

    private void buildGUI(){
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

        this.addComponents(cboTitle, txtFirstName, txtLastName, sexComboBox, optMarital,dateField);

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

        this.addComponents(button);
    
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
}
