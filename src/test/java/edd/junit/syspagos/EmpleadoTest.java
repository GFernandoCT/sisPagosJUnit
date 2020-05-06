package edd.junit.syspagos;

import edd.junit.syspagos.excepciones.CargoException;
import edd.junit.syspagos.excepciones.MesesTrabajoException;
import edd.junit.syspagos.excepciones.NombreEmpleadoException;
import edd.junit.syspagos.excepciones.NumeroEmpleadoException;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmpleadoTest {

    @Test
    @DisplayName("Establecer numero de empleado rango valido")
    public void establecerNumero_empleado_Correcto() {

        Empleado e = new Empleado();
        try {
            e.establecerNumero_empleado("004");
        } catch (NumeroEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(004, e.getNumero_empleado());
    }

    @Test
    @DisplayName("Establecer numero de empleado inferior a 3 digitos")
    public void establecerNumero_empleado_34(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class,() -> {
            e.establecerNumero_empleado("34");
        });
    }

    @Test
    @DisplayName("Establecer numero de empleado superior a 3 digitos")
    public void establecerNumero_empleado_1000() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("1000");
        });
    }

    @Test
    @DisplayName("Establecer numero de empleado limite 000")
    public void establecerNumero_empleado_000() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("0");
        });
    }

    @Test
    @DisplayName("Establecer numero de empleado negativo")
    public void establecerNumero_empleadoNegativo(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () ->{
            e.establecerNumero_empleado("-123");
        });
    }

    @Test
    @DisplayName("Establecer numero de empleado incorrecto")
    public void establecerNumero_empleadoIncorrecto(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () ->{
            e.establecerNumero_empleado("XZY");
        });
    }

    @Test
    @DisplayName("Establecer numero de empleado nulo")
    public void establecerNumero_empleado_nulo() {
        Empleado e = new Empleado();
        String nulo = null;
        Exception exception = Assertions.assertThrows(NullPointerException.class,() -> {
            e.establecerNumero_empleado(nulo);
    });
    }

    @Test
    @DisplayName("Establecer nombre de empleado correcto")
    public void establecerNombre_empleado_Correcto(){
        Empleado e = new Empleado();
        try{
            e.estableceNombre_empleado("Juan");
        } catch (NombreEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals("Juan", e.nombre_empleado);
    }

    @Test
    @DisplayName("Establecer nombre de empleado inferiora 1 caracter")
    public void establecerNombre_empleado_corto(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NombreEmpleadoException.class, () ->{
            e.estableceNombre_empleado("");
        });
    }

    @Test
    @DisplayName("Establecer nombre de empleado superior a 10 caracteres")
    public void establecerNombre_empleado_largo(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NombreEmpleadoException.class, () ->{
            e.estableceNombre_empleado("ABCDEFGHIJK");
        });
    }

    @Test
    @DisplayName("Establecer nombre de empleado incorrecto")
    public void establecerNombre_empleado_incorrecto(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NombreEmpleadoException.class, () ->{
            e.estableceNombre_empleado("1234");
        });
    }

    @Test
    @DisplayName("Establecer nombre de empleado nulo")
    public void establecerNombre_empleado_nulo(){
        Empleado e = new Empleado();
        String nulo = null;
        Exception exception = Assertions.assertThrows(NullPointerException.class, () ->{
            e.estableceNombre_empleado(nulo);
        });
    }

    @Test
    @DisplayName("Establecer meses de trabajo correcto")
    public void establecerMeses_trabajo_Correcto() {

        Empleado e = new Empleado();
        try {
            e.estableceMeses_Trabajo("014");
        } catch (MesesTrabajoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(14, e.getMeses_trabajo());
    }

    @Test
    @DisplayName("Establecer meses de trabajo menor a 1 digito")
    public void establecerMeses_Trabajo_menor(){
        Empleado e = new Empleado();
        String nulo = null;
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () ->{
            e.estableceMeses_Trabajo("01");
        });
    }

    @Test
    @DisplayName("Establecer meses de trabajo superior a 3 digitos")
    public void establecerMeses_Trabajo_mayor(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () ->{
            e.estableceMeses_Trabajo("1000");
        });
    }

    @Test
    @DisplayName("Establecer meses de trabajo negativo")
    public void establecerMeses_Trabajo_negativo(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () ->{
            e.estableceMeses_Trabajo("-020");
        });
    }

    @Test
    @DisplayName("Establecer meses de trabajo incorrecto")
    public void establecerMeses_Trabajo_incorrecto(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () ->{
            e.estableceMeses_Trabajo("hey");
        });
    }

    @Test
    @DisplayName("Establecer meses de trabajo nulo")
    public void establecerMeses_Trabajo_nulo(){
        Empleado e = new Empleado();
        String nulo = null;
        Exception exception = Assertions.assertThrows(NullPointerException.class, () ->{
            e.estableceMeses_Trabajo(nulo);
        });
    }


    @Test
    @DisplayName("Establecer Ser Directivo correcto")
    public void establecerSer_Directivo_correcto(){
        Empleado e = new Empleado();
        try{
            e.establecerSerDirectivo("+");
        } catch (CargoException ex){
            Assertions.fail();
        }
        Assertions.assertTrue(e.getDirectivo());
    }

    @Test
    @DisplayName("Establecer Ser Directivo diferente")
    public void establecerSer_Directivo_diferente(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(CargoException.class, () ->{
            e.establecerSerDirectivo("C");
        });
    }

    @Test
    @DisplayName("Establecer Ser Directivo incorrecto")
    public void establecerSer_Directivo_incorrecto(){
        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(CargoException.class, () ->{
            e.establecerSerDirectivo("1");
        });
    }


    @Test
    @DisplayName("Establecer ser directivo nulo")
    public void establecerSer_Directivo_nulo(){
        Empleado e = new Empleado();
        String nulo = null;
        Exception exception = Assertions.assertThrows(NullPointerException.class, () ->{
            e.establecerSerDirectivo(nulo);
        });
    }

    @Test
    @DisplayName("Resultado Prima P1")
    public void resultadoPrima_P1() {
        Empleado e1 = new Empleado();
        try {
            e1.calcularPrima("625", "Jorge", "122", "+");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P1, e1.getPrima());
    }

    @Test
    @DisplayName("Resultado Prima P2")
    public void resultadoPrima_P2() {
        Empleado e1 = new Empleado();
        try {
            e1.calcularPrima("312", "Erik", "014", "-");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P2, e1.getPrima());
    }

    @Test
    @DisplayName("Resultado Prima P3")
    public void resultadoPrima_P3() {
        Empleado e1 = new Empleado();
        try {
            e1.calcularPrima("432", "Allison", "006", "+");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P3, e1.getPrima());
    }

    @Test
    @DisplayName("Resultado Prima P4")
    public void resultadoPrima_P4() {
        Empleado e1 = new Empleado();
        try {
            e1.calcularPrima("874", "Daniel", "002", "-");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P4, e1.getPrima());
    }


}
