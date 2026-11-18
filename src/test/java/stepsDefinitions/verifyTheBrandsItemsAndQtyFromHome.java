package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class verifyTheBrandsItemsAndQtyFromHome {

    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;
    private Map<String, Integer> marcasYCantidades;

    public verifyTheBrandsItemsAndQtyFromHome(HomePage hp, LoginPage lp, HeaderMenuPage hmp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
    }

    @When("selecciona cada marca del panel izquierdo")
    public void selecciona_cada_marca_del_panel_izquierdo() throws InterruptedException {
        hp.scrollDown(700);
        marcasYCantidades = hp.obtenerMarcasYCantidades();
        Assert.assertFalse(marcasYCantidades.isEmpty(),"No se encontraron marcas en el panel izquierdo");
    }

    @Then("el sistema debe mostrar únicamente productos de la marca seleccionada")
    public void el_sistema_debe_mostrar_únicamente_productos_de_la_marca_seleccionada() {
        for (String marca : marcasYCantidades.keySet()) {
            Assert.assertNotNull(marca);
            Assert.assertFalse(marca.trim().isEmpty(),"Se encontró una marca vacía");
        }
    }

    @Then("el total de productos debe coincidir con la cantidad indicada en el panel de marcas")
    public void el_total_de_productos_debe_coincidir_con_la_cantidad_indicada_en_el_panel_de_marcas() {
        Map<String, Integer> marcasEsperadas = Map.of(
                "POLO", 6,
                "H&M", 5,
                "MADAME", 5,
                "MAST & HARBOUR", 3,
                "BABYHUG", 4,
                "ALLEN SOLLY JUNIOR", 3,
                "KOOKIE KIDS", 3,
                "BIBA", 5
        );
        // Comparar nombres y cantidades
        for (Map.Entry<String, Integer> entry : marcasEsperadas.entrySet()) {
            String marca = entry.getKey();
            Integer cantidadEsperada = entry.getValue();
            Assert.assertTrue(marcasYCantidades.containsKey(marca),"No se encontró la marca en la UI: " + marca);
            Integer cantidadReal = marcasYCantidades.get(marca);
            Assert.assertEquals(cantidadReal, cantidadEsperada,"Cantidad incorrecta para la marca: " + marca);
        }
    }




}
