package org.vaadin.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

//import com.vaadin.flow.server.PWA;
@Route("pro")
public class ProgressiveMainView extends VerticalLayout {

    public ProgressiveMainView() {

        getElement().getStyle().set("border", "1px solid green");
        //setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        setJustifyContentMode(JustifyContentMode.START);

        FlexLayout inputPanel1 = new FlexLayout();
        inputPanel1.getElement().getStyle().set("border", "0px solid red");
        inputPanel1.setFlexDirection(FlexLayout.FlexDirection.ROW);
        inputPanel1.setWrapMode(FlexLayout.WrapMode.WRAP);
        //inputPanel1.setAlignContent(FlexLayout.ContentAlignment.SPACE_AROUND);
        //inputPanel1.setJustifyContentMode(JustifyContentMode.CENTER);

        //---------------------Spalte Empfaenger---------------------------------------
        FlexLayout spalte2 = new FlexLayout();
        spalte2.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        spalte2.setJustifyContentMode(JustifyContentMode.START);
        spalte2.setAlignItems(Alignment.CENTER);
        spalte2.getElement().getStyle().set("border", "0px solid blue");
        spalte2.setWidth("350px");

        FlexLayout empf = getEmpfaenger();
        empf.setWidth("330px");
        spalte2.add(empf);
        inputPanel1.add(spalte2);

        //---------------------Spalte 1---------------------------------------
        FlexLayout spalte1 = new FlexLayout();
        spalte1.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        spalte1.setJustifyContentMode(JustifyContentMode.START);
        spalte1.setAlignItems(Alignment.CENTER);
        spalte1.getElement().getStyle().set("border", "0px solid grey");
        spalte1.setWidth("350px");

        FlexLayout inputset1 = getInputset1();
        inputset1.setWidth("330px");
        spalte1.add(inputset1);

        inputPanel1.add(spalte1);

        //---------------------Spalte 2---------------------------------------
        FlexLayout spalte3 = new FlexLayout();
        spalte3.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        spalte3.setJustifyContentMode(JustifyContentMode.START);
        spalte3.setAlignItems(Alignment.CENTER);
        spalte3.getElement().getStyle().set("border", "0px solid blue");
        spalte3.setWidth("350px");

        FlexLayout termin = getInputset2();
        termin.setWidth("330px");
        spalte3.add(termin);
        inputPanel1.add(spalte3);

        //---------------------Buttons---------------------------------------
        add(inputPanel1);
        HorizontalLayout inputPanel2 = new HorizontalLayout();

        Button save = new Button("Speichern");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button cancel = new Button("Abbrechen");

        inputPanel2.add(save, cancel);

        add(inputPanel2);

        //add(new ProductForm());
        //Button button = new Button("Click me",
        //        e -> Notification.show("HalloWelt"));
        //add(button);
    }

    private FlexLayout getInputset2() {
        FlexLayout result = new FlexLayout();
        result.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        result.setJustifyContentMode(JustifyContentMode.START);
        result.setAlignItems(Alignment.STRETCH);

        ComboBox<String> terminart = new ComboBox<>("Terminart");
        terminart.setItems("Termin bis", "Speed 8", "Speed 10", "Speed 12", "Next-Day", "Fix-Day", "International Next Day", "FixDay 8", "FixDay 10", "FixDay 12");
        result.add(terminart);

        return result;
    }

    private FlexLayout getInputset1() {
        FlexLayout result = new FlexLayout();
        result.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        result.setJustifyContentMode(JustifyContentMode.START);
        result.setAlignItems(Alignment.STRETCH);

        result.add(new TextField("Auftragsnummer"));
        result.add(new DatePicker("Auftragsdatum"));
        result.add(new DatePicker("Ladetag"));

        ComboBox<String> category = new ComboBox<>("Frankatur");
        category.setItems("frei Haus", "unfrei (EXW) o.Fz.");
        result.add(category);

        result.add(new TextField("Angebot"));

        return result;
    }

    private FlexLayout getEmpfaenger() {
        FlexLayout result = new FlexLayout();
        result.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        result.setJustifyContentMode(JustifyContentMode.START);
        result.setAlignItems(Alignment.STRETCH);

        result.add(new TextField("Empfänger Name 1"));
        result.add(new TextField("Empfänger Name 2"));
        result.add(new TextField("Empfänger Strasse"));

        ComboBox<String> land = new ComboBox<>("Land");
        land.setItems("Deutschland", "Europa", "Welt");
        result.add(land);

        HorizontalLayout plzOrt = new HorizontalLayout();
        //plzOrt.getElement().getStyle().set("border", "1px solid red");
        plzOrt.setJustifyContentMode(JustifyContentMode.BETWEEN);
        plzOrt.setAlignItems(Alignment.STRETCH);

        TextField plz = new TextField("E-Plz");
        plz.setWidth("30%");
        TextField ort = new TextField("Empfänger Ort");
        ort.setWidth("70%");

        plzOrt.add(plz);
        plzOrt.add(ort);
        result.add(plzOrt);

        return result;
    }

}
