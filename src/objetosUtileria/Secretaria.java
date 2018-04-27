package objetosUtileria;

import acciones.Capturista;
import acciones.Capturista.onCapturistaAction;
import acciones.Consultor;
import acciones.Consultor.onConsultorInterface;
import java.util.Scanner;

public class Secretaria implements onConsultorInterface,onCapturistaAction {

    Consultor consultor;
    Capturista capturista;
    
    public Secretaria(){
        consultor=new Consultor(this);
        capturista=new Capturista(this);
        boolean cond=true;
        while(cond){
            System.out.println("1) Crear estudiante \n"
                    + "2) Buscar estudiante \n"
                    + "3) Modificar estudiante \n"
                    + "4) Eliminar estudiante \n"
                    + "5) Salir \n");
            Scanner scanner=new Scanner(System.in);
            int entrada=scanner.nextInt();
            switch(entrada){
                case 1:
                    capturista.capturar();
                    break;
                case 2:
                    capturista.ingresoDeNombre();
                    break;
                case 3:
                    break;
                case 4:break;
                case 5:
                    cond=false;
                    break;
            }
        }
    }

    @Override
    public void onConsulta() {
        
    }

    @Override
    public void onError() {
        
    }

    @Override
    public void onCreateEstudiante() {
        System.out.println("---->Tu estudiante ya fue ingresado en la lista");
    }

    @Override
    public void onCaptura() {
        System.out.println("---->Inicia procedimiento de creacion de estudiante");
    }

    @Override
    public void onErrorOnCaptura() {
        
    }

    @Override
    public void onCapturaTerminada(Estudiante estudiante) {
        consultor.agregarEstudianteALista(estudiante);
    }

    @Override
    public void onNombreABuscarIngresado(String ingresado) {
        System.out.println("----->Nombre ingresado");
        consultor.buscar(ingresado);
    }

    @Override
    public void onEstudianteEncontrado(Estudiante estudiante) {
        System.out.println("Nombre encontrado: "+estudiante.getNombre()+" "+estudiante.getPaterno()+" "+estudiante.getMaterno());
    }

    @Override
    public void onIngresadoParaBorrar(String ingresado) {
    
    }

    @Override
    public void onEstudianteBorrado(String data) {
        System.out.println("Estudiante borrado ->"+data);
        consultor.muestra();
    }
    
}
