package br.com.amaurymartin.anvisamedicament.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import br.com.amaurymartin.anvisamedicament.domain.Medicament;
import br.com.amaurymartin.anvisamedicament.services.MedicamentService;

@SpringUI
@Theme("valo")
public class MainUI<medicamentService> extends UI {
	
	private static final long serialVersionUID = 1L;
	
	private VerticalLayout layout;
	private Label header;
	private Layout mainLayout;
	private Layout formLayout;
	
	private ComboBox<Medicament> medicamentField;
	
	private Grid<Medicament> grid;
	private ListDataProvider<Medicament> provider;
	private List<Medicament> gridMedicaments;
	
	@Autowired
	private MedicamentService medicamentService;	
	
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		this.gridMedicaments = new ArrayList<>();
		this.provider = new ListDataProvider<>(this.gridMedicaments);
		
		this.layout = new VerticalLayout();
		this.layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		this.mainLayout = this.createMainLayout();
		
		this.layout.addComponent(this.mainLayout);
		this.layout.setSizeFull();
		
		setContent(this.layout);
	}
	
	private Layout createMainLayout() {
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		this.header = new Label("API de acesso à base de dados Anvisa");
		this.header.addStyleName(ValoTheme.LABEL_H1);
		
		this.formLayout = this.createFormLayout();
		
		mainLayout.addComponent(this.header);
		mainLayout.addComponent(this.formLayout);
		
		return mainLayout;
	}
	
	private Layout createFormLayout() {
		VerticalLayout formLayout = new VerticalLayout();
		formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		this.medicamentField = new ComboBox<Medicament>();
		this.medicamentField.setPlaceholder("Medicamento");
		this.medicamentField.setWidth("400px");
		this.medicamentField.setItems(this.medicamentService.findAll());
		this.medicamentField.setItemCaptionGenerator(Medicament::getProdWithConc);
		this.medicamentField.focus();
		
		Button addButton = new Button("Enter - Adicionar");
		addButton.addClickListener(click -> {
			this.addMedicament(this.medicamentField.getSelectedItem().orElse(null));
			this.medicamentField.setValue(new Medicament());
			this.medicamentField.setItems(this.medicamentService.findAll());
			this.medicamentField.setItemCaptionGenerator(Medicament::getProdWithConc);
		});
		addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		
		horizontalLayout.addComponent(medicamentField);
		horizontalLayout.addComponent(addButton);
		
		Button cleanButton = new Button("F1 - Limpar");
		cleanButton.addClickListener(click -> {
			this.cleanGrid();
			this.medicamentField.setValue(new Medicament());
			this.medicamentField.focus();
		});
		cleanButton.setClickShortcut(ShortcutAction.KeyCode.F1);
		
		this.grid = createGrid();
		
		formLayout.addComponent(horizontalLayout);
		formLayout.addComponent(cleanButton);
		formLayout.addComponent(this.grid);
		
		return formLayout;
	}
	
	private Grid<Medicament> createGrid() {
		Grid<Medicament> grid = new Grid<>();
		grid.setWidth("100%");
		grid.setSelectionMode(SelectionMode.NONE);
		grid.setDataProvider(this.provider);
		
		grid.removeAllColumns();
		grid.addColumn(Medicament::getTx_prod).setCaption("PRODUTO").setWidth(196);
		grid.addColumn(Medicament::getTx_princ_ativo).setCaption("PRINCÍPIO ATIVO").setWidth(220); //142
		grid.addColumn(Medicament::getTx_conc).setCaption("CONCENTRAÇÃO").setWidth(144);
		grid.addColumn(Medicament::getTx_forma_farma).setCaption("FORMA FARMACÊUTICA").setWidth(220);
		grid.addColumn(Medicament::getTx_apres).setCaption("APRESENTAÇÃO").setWidth(220);
		grid.addColumn(Medicament::getCd_reg).setCaption("REGISTRO").setWidth(156);
		grid.addColumn(Medicament::getCd_ean).setCaption("EAN").setWidth(156);
		grid.addColumn(Medicament::getCd_ggrem).setCaption("CÓDIGO GGREM").setWidth(174);
		grid.addColumn(Medicament::getTx_class_terap).setCaption("CLASSE").setWidth(110); //TERAPÊUTICA .setWidth(174)
		grid.addColumn(Medicament::getTx_tipo_prod).setCaption("TIPO DE PRODUTO").setWidth(157);
		grid.addColumn(Medicament::getBl_restr_hosp).setCaption("RESTR HOSP").setWidth(117);
		grid.addColumn(Medicament::getBl_comerc).setCaption("COMERC").setWidth(93);
		grid.addColumn(Medicament::getTx_tarja).setCaption("TARJA").setWidth(131);
		grid.addColumn(Medicament::getTx_lab).setCaption("LABORATÓRIO").setWidth(220);
		grid.addColumn(Medicament::getTx_cnpj).setCaption("CNPJ").setWidth(183);
		
		return grid;
	}
	
	private void cleanGrid() {
		this.gridMedicaments = new ArrayList<>();
		this.provider = new ListDataProvider<>(this.gridMedicaments);
		grid.setDataProvider(this.provider);
		System.out.println("Grid cleaned");
	}
	
	private void addMedicament(Medicament med) {
		if(med != null) {	
			this.gridMedicaments.add(med);
			this.provider.refreshAll();
			System.out.println("Medicamento adicionado");
		} else {
			System.out.println("Medicamento inválido");
		}
	}
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MainUI.class, productionMode = true)
	public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}
	
}
