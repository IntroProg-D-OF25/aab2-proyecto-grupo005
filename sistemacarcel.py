def agra_sent(agra):
    sent_extra = 0
    if agra == 1:
        sent_extra = 3
    elif agra == 2:
        sent_extra = 7
    elif agra == 3:
        sent_extra = 6
    elif agra == 4:
        sent_extra = 8
    elif agra == 5:
        sent_extra = 5
    return sent_extra

def agra_dia(agra):
    sent_extra = 0
    if agra == 1:
        sent_extra = 2
    elif agra == 2:
        sent_extra = 4
    elif agra == 3:
        sent_extra = 3
    elif agra == 4:
        sent_extra = 5
    elif agra == 5:
        sent_extra = 1
    return sent_extra

def busqueda_codigo(ppls_esp, codppl, agra):
    sentencia = 0
    visitas = 0
    sent = 0
    prom = 0
    print("")
    for i in range(len(ppls_esp)):
        if ppls_esp[i][0] == codppl:
            sentencia += int(ppls_esp[i][4])
            visitas += int(ppls_esp[i][5])
            sent += 1

    print("")
    for i in range(len(ppls_esp)):
        if ppls_esp[i][0] == codppl:
            print("\t".join(ppls_esp[i]))

    prom = visitas // sent
    print("")
    print(f"Sentencia Final: {sentencia + agra_sent(agra)}")
    print(f"Dias de visita por mes: {prom - agra_dia(agra)}")

def copiar_matriz(ppls, ppls_esp):
    for i in range(len(ppls)):
        for j in range(len(ppls[0])):
            ppls_esp[i][j] = ppls[i][j]

def concatenar(ppls_esp):
    mostrarDatos = ""
    for i in range(len(ppls_esp)):
        mostrarDatos += "\t".join(ppls_esp[i]) + "\n"
    return mostrarDatos

def ingreso_ppl(ppls):
    for i in range(len(ppls)):
        for j in range(len(ppls[0])):
            if j == 0:
                ppls[i][j] = input(f"Codigo Reo {i+1}: ")
            elif j == 1:
                ppls[i][j] = input("Delito: ")
            elif j == 2:
                ppls[i][j] = input("Gravedad: ")
            elif j == 3:
                ppls[i][j] = input("Fecha (Año-Mes-Dia): ")

def sentencia_visitas(ppls, ppls_esp):
    for i in range(len(ppls)):
        if ppls[i][1] == "Robo":
            if ppls[i][2] == "Leve":
                ppls_esp[i][4] = "2"
                ppls_esp[i][5] = "6"
            elif ppls[i][2] == "Moderado":
                ppls_esp[i][4] = "5"
                ppls_esp[i][5] = "5"
            elif ppls[i][2] == "Grave":
                ppls_esp[i][4] = "10"
                ppls_esp[i][5] = "4"
            elif ppls[i][2] == "MuyGrave":
                ppls_esp[i][4] = "15"
                ppls_esp[i][5] = "3"
        elif ppls[i][1] == "Homicidio":
            if ppls[i][2] == "Leve":
                ppls_esp[i][4] = "5"
                ppls_esp[i][5] = "4"
            elif ppls[i][2] == "Moderado":
                ppls_esp[i][4] = "12"
                ppls_esp[i][5] = "3"
            elif ppls[i][2] == "Grave":
                ppls_esp[i][4] = "20"
                ppls_esp[i][5] = "2"
            elif ppls[i][2] == "MuyGrave":
                ppls_esp[i][4] = "30"
                ppls_esp[i][5] = "1"
        elif ppls[i][1] == "Narcotrafico":
            if ppls[i][2] == "Leve":
                ppls_esp[i][4] = "3"
                ppls_esp[i][5] = "6"
            elif ppls[i][2] == "Moderado":
                ppls_esp[i][4] = "7"
                ppls_esp[i][5] = "5"
            elif ppls[i][2] == "Grave":
                ppls_esp[i][4] = "15"
                ppls_esp[i][5] = "3"
            elif ppls[i][2] == "MuyGrave":
                ppls_esp[i][4] = "25"
                ppls_esp[i][5] = "2"
        elif ppls[i][1] == "Secuestro":
            if ppls[i][2] == "Leve":
                ppls_esp[i][4] = "6"
                ppls_esp[i][5] = "5"
            elif ppls[i][2] == "Moderado":
                ppls_esp[i][4] = "12"
                ppls_esp[i][5] = "3"
            elif ppls[i][2] == "Grave":
                ppls_esp[i][4] = "20"
                ppls_esp[i][5] = "2"
            elif ppls[i][2] == "MuyGrave":
                ppls_esp[i][4] = "35"
                ppls_esp[i][5] = "1"
        elif ppls[i][1] == "Violencia":
            if ppls[i][2] == "Leve":
                ppls_esp[i][4] = "3"
                ppls_esp[i][5] = "6"
            elif ppls[i][2] == "Moderado":
                ppls_esp[i][4] = "7"
                ppls_esp[i][5] = "4"
            elif ppls[i][2] == "Grave":
                ppls_esp[i][4] = "15"
                ppls_esp[i][5] = "2"
            elif ppls[i][2] == "MuyGrave":
                ppls_esp[i][4] = "30"
                ppls_esp[i][5] = "1"

def especificacion():
    print("________________________________________________________________________________________________________")
    print("                                    Delitos y niveles de agravancia")
    print("--------------------------------------------------------------------------------------------------------")
    print("Robo:")
    print("Leve: 2 años de prision | 6 dias de visita al mes")
    print("Moderado: 5 años de prision | 5 dias de visita al mes")
    print("Grave: 10 años de prision | 4 dias de visita al mes")
    print("MuyGrave: 15 años de prision | 3 dias de visita al mes")
    print("Homicidio:")
    print("Leve (homicidio imprudente): 5 años de prision | 4 dias de visita al mes")
    print("Moderado (homicidio simple): 12 años de prision | 3 dias de visita al mes")
    print("Grave (homicidio con agravantes): 20 años de prision | 2 dias de visita al mes")
    print("MuyGrave (asesinato premeditado): 30 años de prision | 1 dias de visita al mes")
    print("Narcotrafico:")
    print("Leve (posesión para consumo personal): 3 años de prision | 6 dias de visita al mes")
    print("Moderado (pequeña distribución): 7 años de prision | 5 dias de visita al mes")
    print("Grave (tráfico a gran escala): 15 años de prision | 3 dias de visita al mes")
    print("MuyGrave (narcotrafico internacional): 25 años de prision | 2 dias de visita al mes")
    print("Secuestro:")
    print("Leve (retencion sin violencia): 6 años de prision | 5 dias de visita al mes")
    print("Moderado (secuestro con liberación sin daño físico): 12 años de prision | 3 dias de visita al mes")
    print("Grave (secuestro con daño físico): 20 años de prision | 2 dias de visita al mes")
    print("MuyGrave (secuestro con asesinato): 35 años de prision | 1 dias de visita al mes")
    print("Violencia:")
    print("Leve (amenazas o agresion sin lesiones graves): 3 años de prision | 6 dias de visita al mes")
    print("Moderado (agresión con lesiones moderadas): 7 años de prisión | 4 dias de visita al mes")
    print("Grave (agresión con daño grave o intento de feminicidio): 15 años de prision | 2 dias de visita al mes")
    print("MuyGrave (feminicidio consumado): 30 años de prision | 1 dias de visita al mes")

def agravantes():
    print("1. Peleas o agresiones a otros internos o personal penitenciario")
    print("   - +3 años adicionales según la gravedad")
    print("   - -2 dias de visita al mes")
    print("2. Intento de fuga o fuga consumada")
    print("   - +7 años adicionales")
    print("   - -4 dias de visita al mes")
    print("3. Posesión o tráfico de drogas dentro del penal")
    print("   - +6 años adicionales")
    print("   - -3 dias de visita al mes")
    print("4. Pertenencia a bandas criminales dentro del penal")
    print("   - +8 años adicionales")
    print("   - -5 dias de visita al mes")
    print("5. Destrucción de propiedad o motín")
    print("   - +5 años adicionales")
    print("   - -1 dias de visita al mes")

def main():
    print("________________________________________________")
    print("        SISTEMA DE CONTROL CARCELARIO")
    print("------------------------------------------------")
    cant = int(input("Ingrese la cantidad de registros de delitos: "))
    ppls = [["" for _ in range(4)] for _ in range(cant)]
    ppls_esp = [["" for _ in range(6)] for _ in range(cant)]
    especificacion()
    ingreso_ppl(ppls)
    copiar_matriz(ppls, ppls_esp)
    sentencia_visitas(ppls, ppls_esp)
    print("_______________________________________________________________________________")
    print("CodigoReo Delito\t Gravedad\t Fecha \t SentenciaAños  VisitaDias")
    print(concatenar(ppls_esp))
    print("-------------------------------------------------------------------------------")
    codppl = input("Buscar Reo por Codigo: ")
    print("______________________")
    agra = 0
    busqueda_codigo(ppls_esp, codppl, agra)
    print("1. Añadir Agravante:")
    print("2. Salir.")
    opc = int(input())
    if opc == 1:
        agravantes()
        agra = int(input())
        busqueda_codigo(ppls_esp, codppl, agra)

if __name__ == "__main__":
    main()
