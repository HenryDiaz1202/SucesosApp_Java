    package com.sucesos;

import com.sucesos.clases.Lluvia;
import com.sucesos.clases.Municipios;
import com.sucesos.clases.Suceso;
import com.sucesos.clases.Temblor;

import java.awt.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int menu_principal(){

        Scanner leer= new Scanner(System.in);
        int opcion_seleccionada=0;

        System.out.println("Bienvenidos a INETER \n");
        System.out.println("Ingrese una opcion");
        System.out.println("1.Agregar municipio");
        System.out.println("2.Mostrar municipio");
        System.out.println("3. Salir");
        try {
            opcion_seleccionada=leer.nextInt();
        }
        catch (Exception e)
        {System.out.println("Opcion invalida");return 0;}
        return opcion_seleccionada;

    }

    private static int menu_suceso()
    {
        Scanner leer= new Scanner(System.in);
        int opcion_seleccionada=0;
        System.out.println("Bienvenidos a Sucesos \n");
        System.out.println("Desea agregar un suceso");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("3. Salir");
        try {
            opcion_seleccionada=leer.nextInt();
        }
        catch (Exception e)
        {System.out.println("Opcion invalida");return 0;}
        return opcion_seleccionada;

    }
    private static int menu_Suceso_interno(){
        Scanner leer= new Scanner(System.in);
        int opcion_seleccionada=0;
        System.out.println("Bienvenidos a Sucesos \n");
        System.out.println("Que suceso agregara?");
        System.out.println("1.Lluvia");
        System.out.println("2.Temblor");
        System.out.println("3.Salir");
        try {
            opcion_seleccionada=leer.nextInt();
        }
        catch (Exception e)
        {System.out.println("Opcion invalida");return 0;}
        return opcion_seleccionada;

    }

    private static int menu_municipio_especifico(){
        Scanner leer= new Scanner(System.in);
        int opcion_menu=0;
        System.out.println("Opciones municipio \n");
        System.out.println("1. Agregar Suceso\n" +
                "2. Borrar Suceso\n" +
                "3. Lluvia de Mayor Duracion\n" +
                "4. Temblor mas alto\n" +
                "5. Mostrar todos los sucesos\n" +
                "6. Salir");
        try {
            opcion_menu=leer.nextInt();
        }
        catch (Exception e)
        {System.out.println("Opcion invalida");return 0;}
        return opcion_menu;

    }



    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Scanner ler = new Scanner(System.in);

        Municipios municipio;
        Suceso sucesos= new Suceso();
        List<Suceso> Lista_suceso;

        float duracion=0;
        int milimetros_agua = 0, latitud_temblor = 0, longitud_temblor = 0;
        String nombre_municipio ="", tipo_lluvia = "";
        LocalDate fecha_hora_suceso= LocalDate.now();
        float extension_territorial = 0, escala_ritcher = 0;

        List<Municipios>lista_municipio = new ArrayList<Municipios>();

        while (true)
        {
            Lista_suceso = new ArrayList<Suceso>();
            int opcion_menu=menu_principal();

            switch (opcion_menu){

                case 1:
                    municipio=new Municipios();

                    System.out.println("\n Municipio \n");
                    System.out.println("\n Ingrese el municipio \n");
                    nombre_municipio=leer.readLine();
                    System.out.println("Ingrese la extension terrotorial");
                    extension_territorial=Float.parseFloat(leer.readLine());

                    int opcion_menu_suceso = menu_suceso();
                    if(opcion_menu_suceso==1){
                        int opcion_suceso_interno=menu_Suceso_interno();
                        if(opcion_suceso_interno==1){
                            Lluvia lluvia;
                            try {
                                System.out.println("Ingrese la duracion del suceso: ");
                                duracion=Float.parseFloat(leer.readLine());
                                //fecha_hora_suceso=LocalDate.now();
                                System.out.println("Ingrese milimetro de agua por hora ");
                                milimetros_agua=ler.nextInt();
                                System.out.println("\n Ingrese el tipo de lluvia");
                                System.out.println("\n 1.Tormenta \n 2.Lluvia normal \n 3.Brisa");
                                tipo_lluvia=leer.readLine();
                            }
                            catch (Exception e) { }

                            lluvia= new Lluvia();
                            lluvia.setMilimetros(milimetros_agua);
                            lluvia.setTipo_lluvia(tipo_lluvia);
                            lluvia.setFecha_hora_suceso(LocalDateTime.now());
                            lluvia.setDuracion(duracion);
                            sucesos = lluvia;

                        }

                        else if(opcion_suceso_interno==2){
                            Temblor temblor;
                            try {
                                System.out.println("Ingrese la duracion del suceso ");
                                duracion=Float.parseFloat(leer.readLine());
                                //fecha_hora_suceso=LocalDate.now();
                                System.out.println("\n Ingrese la latitud \n");
                                latitud_temblor=ler.nextInt();
                                System.out.println("\n Ingrese la longitud \n");
                                longitud_temblor=ler.nextInt();
                                System.out.println("Ingrese la escala de Ritcher");
                                escala_ritcher=Float.parseFloat(leer.readLine());
                            }
                            catch (Exception e){}
                            temblor = new Temblor();
                            temblor.setLatitud(latitud_temblor);
                            temblor.setLongitud(longitud_temblor);
                            temblor.setEscala_ritcher(escala_ritcher);
                            temblor.setFecha_hora_suceso(LocalDateTime.now());
                            temblor.setDuracion(duracion);
                            sucesos = temblor;

                        }
                        //ingresamos los datos de un municipio a
                        municipio.sucesos = Lista_suceso;
                        municipio.nombre = nombre_municipio;
                        municipio.extension = extension_territorial;

                        try {
                            municipio.sucesos.add(sucesos);
                            System.out.println("Se ha ingresado el suceso al municipio");/*
                            System.out.println("duracion = "+Lista_suceso.get(0).getDuracion());*/
                        }catch (Exception e){
                            System.out.println("No se ha agregado el suceso.");
                        }
                        lista_municipio.add(municipio);
                    }
                    else if (opcion_menu_suceso==2){
                        municipio.sucesos = Lista_suceso;
                        municipio.setNombre(nombre_municipio);
                        municipio.setExtension(extension_territorial);
                        lista_municipio.add(municipio);
                    }
                    break;

                case 2:

                    int  opcion_municipio=0;

                    System.out.println("\nLista de municipios \n");
                    System.out.println("--- Mostrando ---");

                    if(lista_municipio.size() <= 0)
                    {
                        System.out.println("No hay municipios registrados.");
                        break;
                    }
                    else{
                    for (int i=0; i< lista_municipio.size();i++)
                    {
                        System.out.println(i+"->  Municipio > " + lista_municipio.get(i).getNombre());
                    }
                    }

                    System.out.println("\n Seleccione un municipio   para ver opciones: ");
                    opcion_municipio = Integer.parseInt(leer.readLine());

                    if(opcion_municipio == -1) break;
                    if(opcion_municipio >= 0 && opcion_municipio < lista_municipio.size()){

                        while (true){
                            int opcion_menu_especif = menu_municipio_especifico();
                            if(opcion_menu_especif == 6) break;

                            switch (opcion_menu_especif){
                                case 1:
                                    System.out.println("Agregar suceso al municipio");
                                    int opcion_suceso_intern = menu_Suceso_interno();
                                    if(opcion_suceso_intern == 1 ){

                                        Lluvia lluvia;
                                        try {
                                            System.out.println("Ingrese la duracion del suceso: ");
                                            duracion=Float.parseFloat(leer.readLine());
                                            fecha_hora_suceso=LocalDate.now();
                                            System.out.println("Ingrese milimetro de agua por hora ");
                                            milimetros_agua=ler.nextInt();
                                            System.out.println("\n Ingrese el tipo de lluvia");
                                            System.out.println("\n 1.Tormenta \n 2.Lluvia normal \n 3.Brisa");
                                            tipo_lluvia=leer.readLine();
                                        }
                                        catch (Exception e) { }

                                        /*lluvia= new Lluvia(5,tipo_lluvia,fecha_hora_suceso,duracion);
                                        sucesos = lluvia;*/
                                        lluvia= new Lluvia();
                                        lluvia.setMilimetros(milimetros_agua);
                                        lluvia.setTipo_lluvia(tipo_lluvia);
                                        lluvia.setFecha_hora_suceso(LocalDateTime.now());
                                        lluvia.setDuracion(duracion);
                                        sucesos = lluvia;
                                    }

                                    else if(opcion_suceso_intern==2){
                                        Temblor temblor;
                                        try {
                                            System.out.println("Ingrese la duracion del suceso ");
                                            duracion=Float.parseFloat(leer.readLine());
                                            fecha_hora_suceso=LocalDate.now();
                                            System.out.println("\n Ingrese la latitud \n");
                                            latitud_temblor=ler.nextInt();
                                            System.out.println("\n Ingrese la longitud \n");
                                            longitud_temblor=ler.nextInt();
                                            System.out.println("Ingrese la escala de Ritcher");
                                            escala_ritcher=Float.parseFloat(leer.readLine());
                                        }
                                        catch (Exception e){}
                                        /*temblor =new Temblor(latitud_temblor,longitud_temblor,escala_ritcher,fecha_hora_suceso,duracion);
                                        sucesos = temblor;*/
                                        temblor = new Temblor();
                                        temblor.setLatitud(latitud_temblor);
                                        temblor.setLongitud(longitud_temblor);
                                        temblor.setEscala_ritcher(escala_ritcher);
                                        temblor.setFecha_hora_suceso(LocalDateTime.now());
                                        temblor.setDuracion(duracion);
                                        sucesos = temblor;
                                    }

                                    lista_municipio.get(opcion_municipio).sucesos.add(sucesos);
                                    break;

                                case 2:
                                    if (lista_municipio.get(opcion_municipio).sucesos.size() > 0){
                                        int opcion_suceso = 0;
                                        List<Suceso> suc = new ArrayList<>();
                                        try {
                                            suc = lista_municipio.get(opcion_municipio).sucesos;
                                        }
                                        catch (Exception e){}

                                        System.out.println(suc.get(0).getDuracion());

                                        System.out.println("Sucesos del municipio \n");

                                        for (int i = 0; i < suc.size(); i++){
                                            if (suc.get(i) instanceof Lluvia){
                                                //System.out.println("\n ☺Estamos en lluvias");
                                                Lluvia lluv = ((Lluvia)(suc.get(i)));
                                                System.out.println(i+") LLUVIA -> " + "Fecha : "+lluv.getFecha_hora_suceso()+" Duración : "+lluv.getDuracion()+" Milímetros : "+lluv.getMilimetros()+" Tipo de lluvia : "+lluv.getTipo_lluvia());
                                            }
                                            else if (suc.get(i).getClass() == Temblor.class){
                                                //System.out.println("\n ☻Estamos en temblores");
                                                Temblor temb = ((Temblor)(suc.get(i)));
                                                System.out.println(i+") Temblor -> "+ "Fecha : "+temb.getFecha_hora_suceso()+" Duración : "+temb.getDuracion()+" Latitud : "+temb.getLatitud()+" Longitud : "+temb.getLongitud()+" Escala de Richter : "+temb.getEscala_ritcher());
                                            }
                                        }
                                        System.out.println("Seleccione suceso a borrar (-1 para salir)");
                                        opcion_suceso = Integer.parseInt(leer.readLine());
                                        if(opcion_suceso == -1)break;
                                        if (opcion_suceso >=0 && opcion_suceso < suc.size()){
                                            suc.remove(opcion_suceso);
                                            System.out.println("Suceso eliminado");
                                            lista_municipio.get(opcion_municipio).sucesos = suc;
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Mostrando la lluvia de mayor duración");
                                    if (lista_municipio.get(opcion_municipio).sucesos.size() > 0) {
                                        List<Suceso> suc = new ArrayList<>();
                                        try {
                                            suc = lista_municipio.get(opcion_municipio).sucesos;
                                        }
                                        catch (Exception e){}

                                        Lluvia lluvia_mayor = new Lluvia();
                                        lluvia_mayor= null;

                                        for(int i = 0; i < suc.size(); i++){
                                            if(suc.get(i) instanceof Temblor) continue;

                                            Lluvia lluv = ((Lluvia)(suc.get(i)));
                                            if(lluvia_mayor == null) lluvia_mayor = lluv;
                                            if(lluvia_mayor.getDuracion() < lluv.getDuracion()){
                                                lluvia_mayor = lluv;
                                            }
                                        }
                                        if(lluvia_mayor != null){
                                            System.out.println("*-**-*-*-*-*-*-*-*-*-*-*-*-*");
                                            System.out.println("Lluvia mayor\n");
                                            System.out.println("Tipo de lluvia: "+lluvia_mayor.getTipo_lluvia() + " Fecha de suceso: " +lluvia_mayor.getFecha_hora_suceso());
                                            System.out.println("*-**-*-*-*-*-*-*-*-*-*-*-*-*");
                                        }
                                    }else{
                                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                        System.out.println("No hay suceso de Lluvia registrado.");
                                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                    }
                                    break;
                                case 4:

                                    System.out.println("Mostrando temblor de mayor duración");
                                    if (lista_municipio.get(opcion_municipio).sucesos.size() > 0) {
                                        List<Suceso> suc = new ArrayList<>();
                                        try {
                                            suc = lista_municipio.get(opcion_municipio).sucesos;
                                        }
                                        catch (Exception e){}

                                        Temblor temblor_mayor = new Temblor();
                                        temblor_mayor= null;

                                        for(int i = 0; i < suc.size(); i++){
                                            if(suc.get(i) instanceof Lluvia) continue;

                                            Temblor tem = ((Temblor)(suc.get(i)));
                                            if(temblor_mayor == null) temblor_mayor = tem;
                                            if(temblor_mayor.getEscala_ritcher() < tem.getEscala_ritcher()){
                                                temblor_mayor = tem;
                                            }
                                        }
                                        if(temblor_mayor != null){
                                            System.out.println("*-**-*-*-*-*-*-*-*-*-*-*-*-*");
                                            System.out.println("Temblor mayor\n");
                                            System.out.println("Fecha ="+temblor_mayor.getFecha_hora_suceso() + "Escala ="+temblor_mayor.getEscala_ritcher());
                                            System.out.println("*-**-*-*-*-*-*-*-*-*-*-*-*-*");
                                        }
                                    }else{
                                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                        System.out.println("No hay suceso de tipo Temblor registrado.");
                                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                    }

                                    break;
                                case 5:
                                    if (lista_municipio.get(opcion_municipio).sucesos.size() > 0){
                                        int opcion_suceso = 0;
                                        List<Suceso> suc = new ArrayList<>();
                                        try {
                                            suc = lista_municipio.get(opcion_municipio).sucesos;
                                        }
                                        catch (Exception e){}

                                        System.out.println(suc.get(0).getDuracion());

                                        System.out.println("Sucesos del municipio \n");

                                        for (int i = 0; i < suc.size(); i++){
                                            if (suc.get(i) instanceof Lluvia){
                                                //System.out.println("\n ☺Estamos en lluvias");
                                                Lluvia lluv = ((Lluvia)(suc.get(i)));
                                                System.out.println(i+") LLUVIA -> " + "Fecha : "+lluv.getFecha_hora_suceso()+" Duración : "+lluv.getDuracion()+" Milímetros : "+lluv.getMilimetros()+" Tipo de lluvia : "+lluv.getTipo_lluvia());
                                            }
                                            else if (suc.get(i).getClass() == Temblor.class){
                                                //System.out.println("\n ☻Estamos en temblores");
                                                Temblor temb = ((Temblor)(suc.get(i)));
                                                System.out.println(i+") Temblor -> "+ "Fecha : "+temb.getFecha_hora_suceso()+" Duración : "+temb.getDuracion()+" Latitud : "+temb.getLatitud()+" Longitud : "+temb.getLongitud()+" Escala de Richter : "+temb.getEscala_ritcher());
                                            }
                                        }
                                    }else{
                                        System.out.println("****************************************\n");
                                        System.out.println("No se han agregado sucesos al municipio.\n");
                                        System.out.println("****************************************");
                                    }
                                    break;
                                default:break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saliendo ...");
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}