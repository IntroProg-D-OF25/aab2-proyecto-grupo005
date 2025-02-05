import java.util.Scanner;
public class Sistema_Control_Carcelaria {
    public static void main(String[] args) {
        Scanner tcl = new Scanner  (System.in);
        int cant, opc, agra = 0;
        String codppl = "";
        System.out.println("________________________________________________");
        System.out.println("        SISTEMA DE CONTROL CARCELARIO");
        System.out.println("------------------------------------------------");
        System.out.println("Ingrese la cantidad de resgitros de delitos: ");
        cant = tcl.nextInt();
        String ppls [][] = new String [cant][4];
        String ppls_esp [][] = new String [cant][6];
        especificacion();
        ingreso_ppl(ppls, tcl);
        copiar_matriz(ppls, ppls_esp);
        sentencia_visitas(ppls, ppls_esp);
        System.out.println("_______________________________________________________________________________");
        System.out.println("CodigoReo Delito\t Gravedad\t Fecha \t SentenciaAños  VisitaDias");
        System.out.println(concatenar(ppls_esp));
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Buscar Reo por Codigo:");
        codppl = tcl.next();
        System.out.println("______________________");
        BusquedaCodigo(ppls_esp, codppl, agra);
        System.out.println("1. Añadir Agravante:");
        System.out.println("2. Salir.");
        opc = tcl.nextInt();
        if (opc == 1) {
            agravantes();
            agra = tcl.nextInt();
            BusquedaCodigo(ppls_esp, codppl, agra);
        }
    }
    public static int agra_sent(int agra) {
        int sent_extra = 0;
        switch (agra) {
            case 1:
                sent_extra = 3;
                break;
            case 2:
                sent_extra = 7;
                break;
            case 3:
                sent_extra = 6;
                break;
            case 4:
                sent_extra = 8;
                break;
            case 5:
                sent_extra = 5;
                break;
            default:
                sent_extra = 0;
            break;
        }
        return sent_extra;
    }
    public static int agra_dia(int agra) {
        int sent_extra = 0;
        switch (agra) {
            case 1:
                sent_extra = 2;
                break;
            case 2:
                sent_extra = 4;
                break;
            case 3:
                sent_extra = 3;
                break;
            case 4:
                sent_extra = 5;
                break;
            case 5:
                sent_extra = 1;
                break;
            default:
                sent_extra = 0;
            break;
        }
        return sent_extra;
    }
    public static void BusquedaCodigo (String ppls_esp [][], String codppl, int agra){
        int sentencia = 0, visitas = 0, sent = 0, prom = 0;
        System.out.println("");
        for (int i = 0; i < ppls_esp.length; i++) {
            if (ppls_esp [i][0].equals(codppl)) {
                sentencia += Integer.valueOf(ppls_esp[i][4]);
                visitas += Integer.valueOf(ppls_esp[i][5]);
                sent ++;
            }
        }
        System.out.println("");
        for (int i = 0; i < ppls_esp.length; i++) {
            if (ppls_esp [i][0].equals(codppl)) {
                for (int j = 0; j < ppls_esp[0].length; j++) {
                    System.out.print(ppls_esp [i][j] + "\t");
                }
            }
            System.out.println("");
        }
        prom = (visitas/sent);
        System.out.println("");
        System.out.println("Sentencia Final: " + (sentencia + agra_sent(agra)));
        System.out.println("Dias de visita por mes: " + ( prom - agra_dia(agra)));
    }
    public static void copiar_matriz (String ppls [][], String ppls_esp [][]){
        for (int i = 0; i < ppls.length; i++) {
            for (int j = 0; j < ppls[0].length; j++) 
             ppls_esp [i][j] = ppls [i][j];
        }
    }
    public static String concatenar(String ppls_esp[][]) {
        String mostrarDatos = "";
        for (int i = 0; i < ppls_esp.length; i++) {
            for (int j = 0; j < ppls_esp[0].length; j++)
                mostrarDatos += ppls_esp[i][j] + "\t";
            mostrarDatos += "\n";
        }
        return mostrarDatos;
    }
    public static void ingreso_ppl(String ppls[][], Scanner tcl) {
        for (int i = 0; i < ppls.length; i++) {
            for (int j = 0; j < ppls[0].length; j++) {
                switch (j) {
                    case 0 -> System.out.print("Codigo Reo " + (i+1) + ": ");
                    case 1 -> System.out.print("Delito: ");
                    case 2 -> System.out.print("Gravedad: ");
                    case 3 -> System.out.print("Fecha (Año-Mes-Dia): ");
                }
                ppls[i][j] = tcl.next();
            }
        }
    }
    public static void sentencia_visitas(String ppls[][], String ppls_esp[][]) {
        for (int i = 0; i < ppls.length; i++) {
            if (ppls[i][1].equals("Robo")) {
                if (ppls[i][2].equals("Leve")) {
                    ppls_esp[i][4] = "2";
                    ppls_esp[i][5] = "6";
                }
                if (ppls[i][2].equals("Moderado")) {
                    ppls_esp[i][4] = "5";
                    ppls_esp[i][5] = "5";                    
                }
                if (ppls[i][2].equals("Grave")) {
                    ppls_esp[i][4] = "10";
                    ppls_esp[i][5] = "4";                    
                }
                if (ppls[i][2].equals("MuyGrave")) {
                    ppls_esp[i][4] = "15";
                    ppls_esp[i][5] = "3";                    
                }
            }
            else if (ppls[i][1].equals("Homicidio")) {
                if (ppls[i][2].equals("Leve")) {
                    ppls_esp[i][4] = "5";
                    ppls_esp[i][5] = "4";
                }
                if (ppls[i][2].equals("Moderado")) {
                    ppls_esp[i][4] = "12";
                    ppls_esp[i][5] = "3";                    
                }
                if (ppls[i][2].equals("Grave")) {
                    ppls_esp[i][4] = "20";
                    ppls_esp[i][5] = "2";                    
                }
                if (ppls[i][2].equals("MuyGrave")) {
                    ppls_esp[i][4] = "30";
                    ppls_esp[i][5] = "1";                    
                }
            }
            else if (ppls[i][1].equals("Narcotrafico")) {
                if (ppls[i][2].equals("Leve")) {
                    ppls_esp[i][4] = "3";
                    ppls_esp[i][5] = "6";
                }
                if (ppls[i][2].equals("Moderado")) {
                    ppls_esp[i][4] = "7";
                    ppls_esp[i][5] = "5";                    
                }
                if (ppls[i][2].equals("Grave")) {
                    ppls_esp[i][4] = "15";
                    ppls_esp[i][5] = "3";                    
                }
                if (ppls[i][2].equals("MuyGrave")) {
                    ppls_esp[i][4] = "25";
                    ppls_esp[i][5] = "2";                    
                }
            }
            else if (ppls[i][1].equals("Secuestro")) {
                if (ppls[i][2].equals("Leve")) {
                    ppls_esp[i][4] = "6";
                    ppls_esp[i][5] = "5";
                }
                if (ppls[i][2].equals("Moderado")) {
                    ppls_esp[i][4] = "12";
                    ppls_esp[i][5] = "3";                    
                }
                if (ppls[i][2].equals("Grave")) {
                    ppls_esp[i][4] = "20";
                    ppls_esp[i][5] = "2";                    
                }
                if (ppls[i][2].equals("MuyGrave")) {
                    ppls_esp[i][4] = "35";
                    ppls_esp[i][5] = "1";                    
                }
            }
            else if (ppls[i][1].equals("Violencia")) {
                if (ppls[i][2].equals("Leve")) {
                    ppls_esp[i][4] = "3";
                    ppls_esp[i][5] = "6";
                }
                if (ppls[i][2].equals("Moderado")) {
                    ppls_esp[i][4] = "7";
                    ppls_esp[i][5] = "4";                    
                }
                if (ppls[i][2].equals("Grave")) {
                    ppls_esp[i][4] = "15";
                    ppls_esp[i][5] = "2";                    
                }
                if (ppls[i][2].equals("MuyGrave")) {
                    ppls_esp[i][4] = "30";
                    ppls_esp[i][5] = "1";                    
                }
            }
        }
    }
    
    public static void especificacion() {
        System.out.println("________________________________________________________________________________________________________");
        System.out.println("                                    Delitos y niveles de agravancia");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Robo:");
        System.out.println("Leve: 2 años de prision | 6 dias de visita al mes");
        System.out.println("Moderado: 5 años de prision | 5 dias de visita al mes");
        System.out.println("Grave: 10 años de prision | 4 dias de visita al mes");
        System.out.println("MuyGrave: 15 años de prision | 3 dias de visita al mes");
        System.out.println("Homicidio:");
        System.out.println("Leve (homicidio imprudente): 5 años de prision | 4 dias de visita al mes");
        System.out.println("Moderado (homicidio simple): 12 años de prision | 3 dias de visita al mes");
        System.out.println("Grave (homicidio con agravantes): 20 años de prision | 2 dias de visita al mes");
        System.out.println("MuyGrave (asesinato premeditado): 30 años de prision | 1 dias de visita al mes");
        System.out.println("Narcotrafico:");
        System.out.println("Leve (posesión para consumo personal): 3 años de prision | 6 dias de visita al mes");
        System.out.println("Moderado (pequeña distribución): 7 años de prision | 5 dias de visita al mes");
        System.out.println("Grave (tráfico a gran escala): 15 años de prision | 3 dias de visita al mes");
        System.out.println("MuyGrave (narcotrafico internacional): 25 años de prision | 2 dias de visita al mes");
        System.out.println("Secuestro:");
        System.out.println("Leve (retencion sin violencia): 6 años de prision | 5 dias de visita al mes");
        System.out.println("Moderado (secuestro con liberación sin daño físico): 12 años de prision | 3 dias de visita al mes");
        System.out.println("Grave (secuestro con daño físico): 20 años de prision | 2 dias de visita al mes");
        System.out.println("MuyGrave (secuestro con asesinato): 35 años de prision | 1 dias de visita al mes");
        System.out.println("Violencia:");
        System.out.println("Leve (amenazas o agresion sin lesiones graves): 3 años de prision | 6 dias de visita al mes");
        System.out.println("Moderado (agresión con lesiones moderadas): 7 años de prisión | 4 dias de visita al mes");
        System.out.println("Grave (agresión con daño grave o intento de feminicidio): 15 años de prision | 2 dias de visita al mes");
        System.out.println("MuyGrave (feminicidio consumado): 30 años de prision | 1 dias de visita al mes");
    }
    public static void agravantes() {
        System.out.println("1. Peleas o agresiones a otros internos o personal penitenciario");
        System.out.println("   - +3 años adicionales según la gravedad");
        System.out.println("   - -2 dias de visita al mes");

        System.out.println("2. Intento de fuga o fuga consumada");
        System.out.println("   - +7 años adicionales");
        System.out.println("   - -4 dias de visita al mes");

        System.out.println("3. Posesión o tráfico de drogas dentro del penal");
        System.out.println("   - +6 años adicionales");
        System.out.println("   - -3 dias de visita al mes");

        System.out.println("4. Pertenencia a bandas criminales dentro del penal");
        System.out.println("   - +8 años adicionales");
        System.out.println("   - -5 dias de visita al mes");

        System.out.println("5. Destrucción de propiedad o motín");
        System.out.println("   - +5 años adicionales");
        System.out.println("   - -1 dias de visita al mes");
    }  
}