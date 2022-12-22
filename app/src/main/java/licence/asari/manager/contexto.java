package licence.asari.manager;

import com.google.firebase.firestore.FirebaseFirestore;

public class contexto {

     public static FirebaseFirestore GremioBd, azulBd;
     private static String keyNick="", keyCodigo="", keypass="",keyDimencion, keyGb;
     private static int  searKeyCodigo;
     private static String keyJornada="";
     private static String keyDuelista="";
     private static String keyDuelista2="";
     private static String keyExpectador="";
     private static String keyExiste="";
     private static String keyDimencion2,keyCodigo2;
     private static String idDuelista1, getIdDuelista2;
     private static  String puntosPj1,puntosPj2;
     private static  int keypartidas;
     private static int keySuma;
     private static  int keySumaVictorias, keyVictora;
     private  int keyJ1,keyJ2,keyJ3,keyJ4,keyJ5,keyJ6,keyJ7,keyJ8,keyJ9,keyJ10,keyJ11,keyJ12;
     private static String keySiguienteN1;
     private static String keySiguienteN2;
     private static  String keyCoidigo3, keyDuelista3;
     private static  String keyId1,keyId2,keyId3;
     private static String keyCodigo3,KeyCodigo4;
     private static String keyPermisoInicio;
     private static String keyTeslaLlave1,keyTeslaLlave2,keyTeslaLlave13,keyTeslaLlave4,keyTeslaLlave5,keyTeslaLlave6,
     keyAviso1,keyAviso2,keyRemitente1,keyRemitente2,keyBloqueo1,keyBloqueo2;
     private static String keyFicha1,keyFicha2,keyFicha3,keyFicha4,keyFicha5,keyFicha6;
     private static String keyGanadorTesla1,keyGanadorTesla2,keyGanadorTesla3;
     private static String keyFich1,keyFich2,keyFich3,keyFich4,keyFich5,keyFich6;
     private  static String keyEscaneoGrenio;
     private static String keyIdGremio;
     private static String keyEventDos;
     private static String keyVida1,keyVida2,keyvida3;
     private static String keyVictGood1,keyVictGood2,keyVictGood3,keyVictGood4,keyVictGood5,keyVictGood6,keyDerrotGood1,keyDerrotGood2,keyDerrotGood3,
             keyDerrotGood4,keyDerrotGood5,keyDerrotGood6;
     private String keyMini1,eyMini2,eyMini3,eyMini4;
     private static String keygrupoAleatorio_1,keygrupoAleatorio_2,keygrupoAleatorio_3,keygrupoAleatorio_4;
     private  String keygrupoAleatorioVerdadero ;
     private static String keyVerdad, keyEstrellas,keyAprovacion_1,keyAprovacion_2,keyVictoriaReino_1,keyVictoriaReino_2,keyDerrotaReino_1;
     private  static String keyApuesta1,keyapuesta2;
     private static String keyCodigoReporte1,keyCodigoReporte2;
     private static String keyOcupado1,keyOcupado2;
     private static String keyFinalReino1,keyFinalReino2,keyFinalReino3,keyFinalReino4,keyFinalReino5,keyFinalReino6,keyFinalReino7,keyFinalReino8
             ,keyFinalReino9,keyFinalReino10, keyEstrellasCero;
//fluctlight  mundo subterraneo
     private static String keyCodigoReport;
     private  static String keySalaDuelo;
     private  static String keyFinalista1,keyFinalista2,keyFinalista3;
     private static String keycEntadaCalabozo, keyCalabozolvl1,keyCalabozolvl2,keyCalabozolvl3,keyCalabozolvl4,
             keyCalabozolvl5,keyCalabozolvl6,keyCalabozolvl7,keyCalabozolvl8,keyCalabozolvl9,keyCalabozolvl10,keyCalabozolvl12,keyCalabozolvl11;
     private static String keyEnlaceCalabozolvl6,keyEnlaceCalabozolvl5,keyEnlaceCalabozolvl4,keyEnlaceCalabozolvl3,keyEnlaceCalabozolvl2,keyEnlaceCalabozolvl1
             ,keyCalabozoActivo,keyCodigoVictoria;
     private static String keyEstado1,keyEstado2,keyEstado3,keyEstado4,keydueloFinal,keyEstado5,keyEstado6,keyEstado7,keyEstado8,keyEstado9
             ,keyEstado10,keyEstado11,keyEstado12;
     private static String keyPuntosV4_1,keyPuntosV4_2,keyPuntosV4_3,keyPuntosV4_4,keysacarPuntolvl4_1,keysacarPuntolvl4_2,keysacarPuntolvl4_3,keysacarPuntolvl4_4
             ,keyParticipante1,keyParticipante2,keyParticipante3,keyParticipante4,keyPuntosV4_5,keyPuntosV4_6,keyParticipante5,keyParticipante6
             ,keyPuntosV4_7,keyPuntosV4_8,keyPuntosV4_9,keyPuntosV4_10,keyParticipante7,keyParticipante8,keyParticipante9,keyParticipante10
             ,keyParticipante11,keyParticipante12,keyPuntosV4_13,keyPuntosV4_11,keyPuntosV4_12;
     private static String keyFinalPuesto1,keyFinalPuesto2,keyFinalPuesto3,keyFinalPuesto4,keyFinalPuesto5,keyFinalPuesto6,keyFinalPuesto7,keyFinalPuesto8
             ,keyFinalPuesto9,keyFinalPuesto10,keyFinalPuesto11,keyFinalPuesto12,keyLugarFinal1,keyLugarFinal2,keyLugarFinal3
             ,keyLugarFinal4,keyLugarFinal5,keyLugarFinal6,keyLugarFinal7,keyLugarFinal8,keyLugarFinal9,keyLugarFinal10,keyLugarFinal11,keyLugarFinal12;
private String keyVideoActivo1,keyVideoActivo2,keyVideoActivo3,keyVideoActivo4,keyRegistroActivo;
private static String keySalaAdmin,keyAdmonEncuentro1,keyAdmonEncuentro2;
private static String keyTier1,keyTier2,keyTier3,keyTier4,keyTier5,keyTier6,keyTier7,keyTier8,keyTier9,keyTier10
        ,keyFinalista01,keyFinalista02,keyFinalista03,keyFinalista04,keyFinalista05,keyFinalista06,keyFinalista07,keyFinalista08,keyFinalista09,keyFinalista10
        ,keyFinalista11,keyFinalista12;
private static String keyTorneoActivo,keySalaActiva,keyActivacionRamdom, keyRutaDungeon1,keyRutaDungeon2, keyTablaGeneral,keyTorneo1,keyTorneo2,keyTorneo3;
private static String keyParticipanteEspera1,keyParticipanteEspera2,keyParticipanteEspera3,keyParticipanteEspera4,keyParticipanteEspera5,keyParticipanteEspera6
        ,keyParticipanteEspera7,keyParticipanteEspera8,keyParticipanteEspera9,keyParticipanteEspera10,keyParticipanteEspera11,keyParticipanteEspera12
        ,keyPuntosEspera1,keyPuntosEspera2,keyPuntosEspera3,keyPuntosEspera4,keyPuntosEspera5,keyPuntosEspera6,keyPuntosEspera7,keyPuntosEspera8
        ,keyPuntosEspera9,keyPuntosEspera10,keyTotalPuntoEspera1,keyTotalPuntoEspera2,keyTotalPuntoEspera3,keyTotalPuntoEspera4,keyTotalPuntoEspera5
        ,keyTotalPuntoEspera6,keyTotalPuntoEspera7,keyTotalPuntoEspera8,keyTotalPuntoEspera9,keyTotalPuntoEspera10;
    private static String keyParticipanteLose1,keyParticipanteLose2,keyParticipanteLose3,keyParticipanteLose4,keyParticipanteLose5,keyParticipanteLose6,keyParticipanteLose7
    ,keyParticipanteLose8,keyParticipanteLose9,keyParticipanteLose10,keyParticipanteLose11,keyParticipanteLose12;
private static String keyEntradaLose,keySystemPs1,keySystemPs2,keySystemPs3,keySystemPsG,keyCalabozoAtivoLose;
private static String keyidClan1,keyidClan2,keyidClan3,keyidClan4,keyidClan5,keyidClan6,keyExclucion,keyConteo;
private static String  keyFormatoImgagen,keyTotalDerrotasLose,keyTotalVictoriasLose;
private  static String  keyTime1Main, keyTime2Main, keyN, keyEquipo1,keyEquipo2,keyEquipo3,keyEquipo4,keyEquipo5,keyEquipo6,keyEquipo7,keyEquipo8,keyEquipo9
        ,keyEquipo10;
private  static   String keyfechasUnder,keyfechasUnder2, keyEstadoUnder1,keyEstadoUnder2,keyEncuentro1,keyEncuentro2,keyNGrupos,keyVsEquipo1,keyVsEquipo2,keyVsEquipo3
        ,keyVsEquipo4,keyVsEquipo5,keyVsEquipo6, keyEleccionTorneoReport,keyResultReport,keyCodeReport,keyVerificReport, keyconteoUnder,keyEquipoUnder_1
        ,keyEquipoUnder_2,keyVerificationReport_1,eyVerificaionReport_2;

private static  String keyUnderFases, keyUnderGrup1,keyUnderGrup2,keyGrupoN1,keyGrupoN2,keyGrupoN3,keyGrupoN4,keyGrupoN5,keyRadio1,keyRadio2;



     public String getKeyDimencion() {
          return keyDimencion;
     }

     public void setKeyDimencion(String keyDimencion) {
          this.keyDimencion = keyDimencion;
     }

     public String getKeyCodigo() {
          return keyCodigo;
     }

     public void setKeyCodigo(String keyCodigo) {
          this.keyCodigo = keyCodigo;
     }

     public String getKeypass() {
          return keypass;
     }

     public void setKeypass(String keypass) {
          this.keypass = keypass;
     }

     public String getKeyNick() {
          return keyNick;
     }

     public void setKeyNick(String keyNick) {
          this.keyNick = keyNick;
     }

     public String getKeyGb() {
          return keyGb;
     }

     public void setKeyGb(String keyGb) {
          this.keyGb = keyGb;
     }

     public int getSearKeyCodigo() {
          return searKeyCodigo;
     }

     public void setSearKeyCodigo(int searKeyCodigo) {
          this.searKeyCodigo = searKeyCodigo;
     }

     public String getKeyJornada() {
          return keyJornada;
     }

     public void setKeyJornada(String keyJornada) {
          this.keyJornada = keyJornada;
     }

     public String getKeyDuelista() {
          return keyDuelista;
     }

     public void setKeyDuelista(String keyDuelista) {
          this.keyDuelista = keyDuelista;
     }

     public String getKeyDuelista2() {
          return keyDuelista2;
     }

     public void setKeyDuelista2(String keyDuelista2) {
          this.keyDuelista2 = keyDuelista2;
     }

     public String getKeyExpectador() {
          return keyExpectador;
     }

     public void setKeyExpectador(String keyExpectador) {
          this.keyExpectador = keyExpectador;
     }

     public String getKeyExiste() {
          return keyExiste;
     }

     public void setKeyExiste(String keyExiste) {
          this.keyExiste = keyExiste;
     }

     public String getKeyDimencion2() {
          return keyDimencion2;
     }

     public void setKeyDimencion2(String keyDimencion2) {
          this.keyDimencion2 = keyDimencion2;
     }

     public String getKeyCodigo2() {
          return keyCodigo2;
     }

     public void setKeyCodigo2(String keyCodigo2) {
          this.keyCodigo2 = keyCodigo2;
     }

     public String getIdDuelista1() {
          return idDuelista1;
     }

     public void setIdDuelista1(String idDuelista1) {
          this.idDuelista1 = idDuelista1;
     }

     public String getGetIdDuelista2() {
          return getIdDuelista2;
     }

     public void setGetIdDuelista2(String getIdDuelista2) {
          this.getIdDuelista2 = getIdDuelista2;
     }

     public String getPuntosPj1() {
          return puntosPj1;
     }

     public void setPuntosPj1(String puntosPj1) {
          this.puntosPj1 = puntosPj1;
     }

     public String getPuntosPj2() {
          return puntosPj2;
     }

     public void setPuntosPj2(String puntosPj2) {
          this.puntosPj2 = puntosPj2;
     }

     public int getKeypartidas() {
          return keypartidas;
     }

     public void setKeypartidas(int keypartidas) {
          this.keypartidas = keypartidas;
     }

     public int getKeySuma() {
          return keySuma;
     }

     public void setKeySuma(int keySuma) {
          this.keySuma = keySuma;
     }

     public int getKeySumaVictorias() {
          return keySumaVictorias;
     }

     public void setKeySumaVictorias(int keySumaVictorias) {
          this.keySumaVictorias = keySumaVictorias;
     }

     public int getKeyVictora() {
          return keyVictora;
     }

     public void setKeyVictora(int keyVictora) {
          this.keyVictora = keyVictora;
     }

     public int getKeyJ1() {
          return keyJ1;
     }

     public void setKeyJ1(int keyJ1) {
          this.keyJ1 = keyJ1;
     }

     public int getKeyJ2() {
          return keyJ2;
     }

     public void setKeyJ2(int keyJ2) {
          this.keyJ2 = keyJ2;
     }

     public int getKeyJ3() {
          return keyJ3;
     }

     public void setKeyJ3(int keyJ3) {
          this.keyJ3 = keyJ3;
     }

     public int getKeyJ4() {
          return keyJ4;
     }

     public void setKeyJ4(int keyJ4) {
          this.keyJ4 = keyJ4;
     }

     public int getKeyJ5() {
          return keyJ5;
     }

     public void setKeyJ5(int keyJ5) {
          this.keyJ5 = keyJ5;
     }

     public int getKeyJ6() {
          return keyJ6;
     }

     public void setKeyJ6(int keyJ6) {
          this.keyJ6 = keyJ6;
     }

     public int getKeyJ7() {
          return keyJ7;
     }

     public void setKeyJ7(int keyJ7) {
          this.keyJ7 = keyJ7;
     }

     public int getKeyJ8() {
          return keyJ8;
     }

     public void setKeyJ8(int keyJ8) {
          this.keyJ8 = keyJ8;
     }

     public int getKeyJ9() {
          return keyJ9;
     }

     public void setKeyJ9(int keyJ9) {
          this.keyJ9 = keyJ9;
     }

     public int getKeyJ10() {
          return keyJ10;
     }

     public void setKeyJ10(int keyJ10) {
          this.keyJ10 = keyJ10;
     }

     public int getKeyJ11() {
          return keyJ11;
     }

     public void setKeyJ11(int keyJ11) {
          this.keyJ11 = keyJ11;
     }

     public int getKeyJ12() {
          return keyJ12;
     }

     public void setKeyJ12(int keyJ12) {
          this.keyJ12 = keyJ12;
     }

     public String getKeySiguienteN1() {
          return keySiguienteN1;
     }

     public void setKeySiguienteN1(String keySiguienteN1) {
          this.keySiguienteN1 = keySiguienteN1;
     }

     public String getKeySiguienteN2() {
          return keySiguienteN2;
     }

     public void setKeySiguienteN2(String keySiguienteN2) {
          this.keySiguienteN2 = keySiguienteN2;
     }

     public String getKeyCoidigo3() {
          return keyCoidigo3;
     }

     public void setKeyCoidigo3(String keyCoidigo3) {
          this.keyCoidigo3 = keyCoidigo3;
     }

     public String getKeyDuelista3() {
          return keyDuelista3;
     }

     public void setKeyDuelista3(String keyDuelista3) {
          this.keyDuelista3 = keyDuelista3;
     }

     public String getKeyId1() {
          return keyId1;
     }

     public void setKeyId1(String keyId1) {
          this.keyId1 = keyId1;
     }

     public String getKeyId2() {
          return keyId2;
     }

     public void setKeyId2(String keyId2) {
          this.keyId2 = keyId2;
     }

     public String getKeyId3() {
          return keyId3;
     }

     public void setKeyId3(String keyId3) {
          this.keyId3 = keyId3;
     }

     public String getKeyCodigo3() {
          return keyCodigo3;
     }

     public void setKeyCodigo3(String keyCodigo3) {
          this.keyCodigo3 = keyCodigo3;
     }

     public String getKeyCodigo4() {
          return KeyCodigo4;
     }

     public void setKeyCodigo4(String keyCodigo4) {
          KeyCodigo4 = keyCodigo4;
     }

     public String getKeyPermisoInicio() {
          return keyPermisoInicio;
     }

     public void setKeyPermisoInicio(String keyPermisoInicio) {
          this.keyPermisoInicio = keyPermisoInicio;
     }

     public String getKeyTeslaLlave1() {
          return keyTeslaLlave1;
     }

     public void setKeyTeslaLlave1(String keyTeslaLlave1) {
          this.keyTeslaLlave1 = keyTeslaLlave1;
     }

     public String getKeyTeslaLlave2() {
          return keyTeslaLlave2;
     }

     public void setKeyTeslaLlave2(String keyTeslaLlave2) {
          this.keyTeslaLlave2 = keyTeslaLlave2;
     }

     public String getKeyTeslaLlave13() {
          return keyTeslaLlave13;
     }

     public void setKeyTeslaLlave13(String keyTeslaLlave13) {
          this.keyTeslaLlave13 = keyTeslaLlave13;
     }

     public String getKeyTeslaLlave4() {
          return keyTeslaLlave4;
     }

     public void setKeyTeslaLlave4(String keyTeslaLlave4) {
          this.keyTeslaLlave4 = keyTeslaLlave4;
     }

     public String getKeyTeslaLlave5() {
          return keyTeslaLlave5;
     }

     public void setKeyTeslaLlave5(String keyTeslaLlave5) {
          this.keyTeslaLlave5 = keyTeslaLlave5;
     }

     public String getKeyTeslaLlave6() {
          return keyTeslaLlave6;
     }

     public void setKeyTeslaLlave6(String keyTeslaLlave6) {
          this.keyTeslaLlave6 = keyTeslaLlave6;
     }

     public String getKeyAviso1() {
          return keyAviso1;
     }

     public void setKeyAviso1(String keyAviso1) {
          this.keyAviso1 = keyAviso1;
     }

     public String getKeyAviso2() {
          return keyAviso2;
     }

     public void setKeyAviso2(String keyAviso2) {
          this.keyAviso2 = keyAviso2;
     }

     public String getKeyRemitente1() {
          return keyRemitente1;
     }

     public void setKeyRemitente1(String keyRemitente1) {
          this.keyRemitente1 = keyRemitente1;
     }

     public String getKeyRemitente2() {
          return keyRemitente2;
     }

     public void setKeyRemitente2(String keyRemitente2) {
          this.keyRemitente2 = keyRemitente2;
     }

     public String getKeyBloqueo1() {
          return keyBloqueo1;
     }

     public void setKeyBloqueo1(String keyBloqueo1) {
          this.keyBloqueo1 = keyBloqueo1;
     }

     public String getKeyBloqueo2() {
          return keyBloqueo2;
     }

     public void setKeyBloqueo2(String keyBloqueo2) {
          this.keyBloqueo2 = keyBloqueo2;
     }

     public String getKeyFicha1() {
          return keyFicha1;
     }

     public void setKeyFicha1(String keyFicha1) {
          this.keyFicha1 = keyFicha1;
     }

     public String getKeyFicha2() {
          return keyFicha2;
     }

     public void setKeyFicha2(String keyFicha2) {
          this.keyFicha2 = keyFicha2;
     }

     public String getKeyFicha3() {
          return keyFicha3;
     }

     public void setKeyFicha3(String keyFicha3) {
          this.keyFicha3 = keyFicha3;
     }

     public String getKeyFicha4() {
          return keyFicha4;
     }

     public void setKeyFicha4(String keyFicha4) {
          this.keyFicha4 = keyFicha4;
     }

     public String getKeyFicha5() {
          return keyFicha5;
     }

     public void setKeyFicha5(String keyFicha5) {
          this.keyFicha5 = keyFicha5;
     }

     public String getKeyFicha6() {
          return keyFicha6;
     }

     public void setKeyFicha6(String keyFicha6) {
          this.keyFicha6 = keyFicha6;
     }

     public String getKeyGanadorTesla3() {
          return keyGanadorTesla3;
     }

     public void setKeyGanadorTesla3(String keyGanadorTesla3) {
          this.keyGanadorTesla3 = keyGanadorTesla3;
     }

     public String getKeyGanadorTesla2() {
          return keyGanadorTesla2;
     }

     public void setKeyGanadorTesla2(String keyGanadorTesla2) {
          this.keyGanadorTesla2 = keyGanadorTesla2;
     }

     public String getKeyGanadorTesla1() {
          return keyGanadorTesla1;
     }

     public void setKeyGanadorTesla1(String keyGanadorTesla1) {
          this.keyGanadorTesla1 = keyGanadorTesla1;
     }

     public String getKeyFich1() {
          return keyFich1;
     }

     public void setKeyFich1(String keyFich1) {
          this.keyFich1 = keyFich1;
     }

     public String getKeyFich2() {
          return keyFich2;
     }

     public void setKeyFich2(String keyFich2) {
          this.keyFich2 = keyFich2;
     }

     public String getKeyFich3() {
          return keyFich3;
     }

     public void setKeyFich3(String keyFich3) {
          this.keyFich3 = keyFich3;
     }

     public String getKeyFich4() {
          return keyFich4;
     }

     public void setKeyFich4(String keyFich4) {
          this.keyFich4 = keyFich4;
     }

     public String getKeyFich5() {
          return keyFich5;
     }

     public void setKeyFich5(String keyFich5) {
          this.keyFich5 = keyFich5;
     }

     public String getKeyFich6() {
          return keyFich6;
     }

     public void setKeyFich6(String keyFich6) {
          this.keyFich6 = keyFich6;
     }

     public String getKeyEscaneoGrenio() {
          return keyEscaneoGrenio;
     }

     public void setKeyEscaneoGrenio(String keyEscaneoGrenio) {
          this.keyEscaneoGrenio = keyEscaneoGrenio;
     }

     public String getKeyIdGremio() {
          return keyIdGremio;
     }

     public void setKeyIdGremio(String keyIdGremio) {
          this.keyIdGremio = keyIdGremio;
     }

     public String getKeyEventDos() {
          return keyEventDos;
     }

     public void setKeyEventDos(String keyEventDos) {
          this.keyEventDos = keyEventDos;
     }

     public String getKeyVida1() {
          return keyVida1;
     }

     public void setKeyVida1(String keyVida1) {
          this.keyVida1 = keyVida1;
     }

     public String getKeyVida2() {
          return keyVida2;
     }

     public void setKeyVida2(String keyVida2) {
          this.keyVida2 = keyVida2;
     }

     public String getKeyvida3() {
          return keyvida3;
     }

     public void setKeyvida3(String keyvida3) {
          this.keyvida3 = keyvida3;
     }

     public String getKeyDerrotGood4() {
          return keyDerrotGood4;
     }

     public void setKeyDerrotGood4(String keyDerrotGood4) {
          this.keyDerrotGood4 = keyDerrotGood4;
     }

     public String getKeyVictGood1() {
          return keyVictGood1;
     }

     public void setKeyVictGood1(String keyVictGood1) {
          this.keyVictGood1 = keyVictGood1;
     }

     public String getKeyVictGood2() {
          return keyVictGood2;
     }

     public void setKeyVictGood2(String keyVictGood2) {
          this.keyVictGood2 = keyVictGood2;
     }

     public String getKeyVictGood3() {
          return keyVictGood3;
     }

     public void setKeyVictGood3(String keyVictGood3) {
          this.keyVictGood3 = keyVictGood3;
     }

     public String getKeyVictGood4() {
          return keyVictGood4;
     }

     public void setKeyVictGood4(String keyVictGood4) {
          this.keyVictGood4 = keyVictGood4;
     }

     public String getKeyVictGood5() {
          return keyVictGood5;
     }

     public void setKeyVictGood5(String keyVictGood5) {
          this.keyVictGood5 = keyVictGood5;
     }

     public String getKeyVictGood6() {
          return keyVictGood6;
     }

     public void setKeyVictGood6(String keyVictGood6) {
          this.keyVictGood6 = keyVictGood6;
     }

     public String getKeyDerrotGood1() {
          return keyDerrotGood1;
     }

     public void setKeyDerrotGood1(String keyDerrotGood1) {
          this.keyDerrotGood1 = keyDerrotGood1;
     }

     public String getKeyDerrotGood2() {
          return keyDerrotGood2;
     }

     public void setKeyDerrotGood2(String keyDerrotGood2) {
          this.keyDerrotGood2 = keyDerrotGood2;
     }

     public String getKeyDerrotGood3() {
          return keyDerrotGood3;
     }

     public void setKeyDerrotGood3(String keyDerrotGood3) {
          this.keyDerrotGood3 = keyDerrotGood3;
     }

     public String getKeyDerrotGood5() {
          return keyDerrotGood5;
     }

     public void setKeyDerrotGood5(String keyDerrotGood5) {
          this.keyDerrotGood5 = keyDerrotGood5;
     }

     public String getKeyDerrotGood6() {
          return keyDerrotGood6;
     }

     public void setKeyDerrotGood6(String keyDerrotGood6) {
          this.keyDerrotGood6 = keyDerrotGood6;
     }

     public String getKeyMini1() {
          return keyMini1;
     }

     public void setKeyMini1(String keyMini1) {
          this.keyMini1 = keyMini1;
     }

     public String getEyMini2() {
          return eyMini2;
     }

     public void setEyMini2(String eyMini2) {
          this.eyMini2 = eyMini2;
     }

     public String getEyMini3() {
          return eyMini3;
     }

     public void setEyMini3(String eyMini3) {
          this.eyMini3 = eyMini3;
     }

     public String getEyMini4() {
          return eyMini4;
     }

     public void setEyMini4(String eyMini4) {
          this.eyMini4 = eyMini4;
     }

     public String getKeygrupoAleatorio_1() {
          return keygrupoAleatorio_1;
     }

     public void setKeygrupoAleatorio_1(String keygrupoAleatorio_1) {
          this.keygrupoAleatorio_1 = keygrupoAleatorio_1;
     }

     public String getKeygrupoAleatorio_2() {
          return keygrupoAleatorio_2;
     }

     public void setKeygrupoAleatorio_2(String keygrupoAleatorio_2) {
          this.keygrupoAleatorio_2 = keygrupoAleatorio_2;
     }

     public String getKeygrupoAleatorio_3() {
          return keygrupoAleatorio_3;
     }

     public void setKeygrupoAleatorio_3(String keygrupoAleatorio_3) {
          this.keygrupoAleatorio_3 = keygrupoAleatorio_3;
     }

     public String getKeygrupoAleatorio_4() {
          return keygrupoAleatorio_4;
     }

     public void setKeygrupoAleatorio_4(String keygrupoAleatorio_4) {
          this.keygrupoAleatorio_4 = keygrupoAleatorio_4;
     }

     public String getKeygrupoAleatorioVerdadero() {
          return keygrupoAleatorioVerdadero;
     }

     public void setKeygrupoAleatorioVerdadero(String keygrupoAleatorioVerdadero) {
          this.keygrupoAleatorioVerdadero = keygrupoAleatorioVerdadero;
     }

     public String getKeyVerdad() {
          return keyVerdad;
     }

     public void setKeyVerdad(String keyVerdad) {
          this.keyVerdad = keyVerdad;
     }

     public String getKeyApuesta1() {
          return keyApuesta1;
     }

     public void setKeyApuesta1(String keyApuesta1) {
          this.keyApuesta1 = keyApuesta1;
     }

     public String getKeyapuesta2() {
          return keyapuesta2;
     }

     public void setKeyapuesta2(String keyapuesta2) {
          this.keyapuesta2 = keyapuesta2;
     }

     public String getKeyEstrellas() {
          return keyEstrellas;
     }

     public void setKeyEstrellas(String keyEstrellas) {
          this.keyEstrellas = keyEstrellas;
     }

     public String getKeyAprovacion_1() {
          return keyAprovacion_1;
     }

     public void setKeyAprovacion_1(String keyAprovacion_1) {
          this.keyAprovacion_1 = keyAprovacion_1;
     }

     public String getKeyAprovacion_2() {
          return keyAprovacion_2;
     }

     public void setKeyAprovacion_2(String keyAprovacion_2) {
          this.keyAprovacion_2 = keyAprovacion_2;
     }

     public String getKeyVictoriaReino_1() {
          return keyVictoriaReino_1;
     }

     public void setKeyVictoriaReino_1(String keyVictoriaReino_1) {
          this.keyVictoriaReino_1 = keyVictoriaReino_1;
     }

     public String getKeyVictoriaReino_2() {
          return keyVictoriaReino_2;
     }

     public void setKeyVictoriaReino_2(String keyVictoriaReino_2) {
          this.keyVictoriaReino_2 = keyVictoriaReino_2;
     }

     public String getKeyDerrotaReino_1() {
          return keyDerrotaReino_1;
     }

     public void setKeyDerrotaReino_1(String keyDerrotaReino_1) {
          this.keyDerrotaReino_1 = keyDerrotaReino_1;
     }

     public String getKeyCodigoReporte2() {
          return keyCodigoReporte2;
     }

     public void setKeyCodigoReporte2(String keyCodigoReporte2) {
          this.keyCodigoReporte2 = keyCodigoReporte2;
     }

     public String getKeyCodigoReporte1() {
          return keyCodigoReporte1;
     }

     public void setKeyCodigoReporte1(String keyCodigoReporte1) {
          this.keyCodigoReporte1 = keyCodigoReporte1;
     }

     public String getKeyOcupado1() {
          return keyOcupado1;
     }

     public void setKeyOcupado1(String keyOcupado1) {
          this.keyOcupado1 = keyOcupado1;
     }

     public String getKeyOcupado2() {
          return keyOcupado2;
     }

     public void setKeyOcupado2(String keyOcupado2) {
          this.keyOcupado2 = keyOcupado2;
     }

     public String getKeyFinalReino1() {
          return keyFinalReino1;
     }

     public void setKeyFinalReino1(String keyFinalReino1) {
          this.keyFinalReino1 = keyFinalReino1;
     }

     public String getKeyFinalReino2() {
          return keyFinalReino2;
     }

     public void setKeyFinalReino2(String keyFinalReino2) {
          this.keyFinalReino2 = keyFinalReino2;
     }

     public String getKeyFinalReino3() {
          return keyFinalReino3;
     }

     public void setKeyFinalReino3(String keyFinalReino3) {
          this.keyFinalReino3 = keyFinalReino3;
     }

     public String getKeyFinalReino4() {
          return keyFinalReino4;
     }

     public void setKeyFinalReino4(String keyFinalReino4) {
          this.keyFinalReino4 = keyFinalReino4;
     }

     public String getKeyFinalReino5() {
          return keyFinalReino5;
     }

     public void setKeyFinalReino5(String keyFinalReino5) {
          this.keyFinalReino5 = keyFinalReino5;
     }

     public String getKeyEstrellasCero() {
          return keyEstrellasCero;
     }

     public void setKeyEstrellasCero(String keyEstrellasCero) {
          this.keyEstrellasCero = keyEstrellasCero;
     }

     public String getKeyParticipante10() {
          return keyParticipante10;
     }

     public void setKeyParticipante10(String keyParticipante10) {
          this.keyParticipante10 = keyParticipante10;
     }

     public String getKeyParticipante9() {
          return keyParticipante9;
     }

     public void setKeyParticipante9(String keyParticipante9) {
          this.keyParticipante9 = keyParticipante9;
     }

     public String getKeyParticipante8() {
          return keyParticipante8;
     }

     public void setKeyParticipante8(String keyParticipante8) {
          this.keyParticipante8 = keyParticipante8;
     }

     public String getKeyParticipante7() {
          return keyParticipante7;
     }

     public void setKeyParticipante7(String keyParticipante7) {
          this.keyParticipante7 = keyParticipante7;
     }

     public String getKeyPuntosV4_10() {
          return keyPuntosV4_10;
     }

     public void setKeyPuntosV4_10(String keyPuntosV4_10) {
          this.keyPuntosV4_10 = keyPuntosV4_10;
     }

     public String getKeyPuntosV4_9() {
          return keyPuntosV4_9;
     }

     public void setKeyPuntosV4_9(String keyPuntosV4_9) {
          this.keyPuntosV4_9 = keyPuntosV4_9;
     }

     public String getKeyPuntosV4_8() {
          return keyPuntosV4_8;
     }

     public void setKeyPuntosV4_8(String keyPuntosV4_8) {
          this.keyPuntosV4_8 = keyPuntosV4_8;
     }

     public String getKeyPuntosV4_7() {
          return keyPuntosV4_7;
     }

     public void setKeyPuntosV4_7(String keyPuntosV4_7) {
          this.keyPuntosV4_7 = keyPuntosV4_7;
     }

     public String getKeyParticipante6() {
          return keyParticipante6;
     }

     public void setKeyParticipante6(String keyParticipante6) {
          this.keyParticipante6 = keyParticipante6;
     }

     public String getKeyParticipante5() {
          return keyParticipante5;
     }

     public void setKeyParticipante5(String keyParticipante5) {
          this.keyParticipante5 = keyParticipante5;
     }

     public String getKeyPuntosV4_6() {
          return keyPuntosV4_6;
     }

     public void setKeyPuntosV4_6(String keyPuntosV4_6) {
          this.keyPuntosV4_6 = keyPuntosV4_6;
     }

     public String getKeyPuntosV4_5() {
          return keyPuntosV4_5;
     }

     public void setKeyPuntosV4_5(String keyPuntosV4_5) {
          this.keyPuntosV4_5 = keyPuntosV4_5;
     }

     public String getKeyParticipante4() {
          return keyParticipante4;
     }

     public void setKeyParticipante4(String keyParticipante4) {
          this.keyParticipante4 = keyParticipante4;
     }

     public String getKeyParticipante3() {
          return keyParticipante3;
     }

     public void setKeyParticipante3(String keyParticipante3) {
          this.keyParticipante3 = keyParticipante3;
     }

     public String getKeyParticipante2() {
          return keyParticipante2;
     }

     public void setKeyParticipante2(String keyParticipante2) {
          this.keyParticipante2 = keyParticipante2;
     }

     public String getKeyParticipante1() {
          return keyParticipante1;
     }

     public void setKeyParticipante1(String keyParticipante1) {
          this.keyParticipante1 = keyParticipante1;
     }

     public String getKeysacarPuntolvl4_4() {
          return keysacarPuntolvl4_4;
     }

     public void setKeysacarPuntolvl4_4(String keysacarPuntolvl4_4) {
          this.keysacarPuntolvl4_4 = keysacarPuntolvl4_4;
     }

     public String getKeysacarPuntolvl4_3() {
          return keysacarPuntolvl4_3;
     }

     public void setKeysacarPuntolvl4_3(String keysacarPuntolvl4_3) {
          this.keysacarPuntolvl4_3 = keysacarPuntolvl4_3;
     }

     public String getKeysacarPuntolvl4_2() {
          return keysacarPuntolvl4_2;
     }

     public void setKeysacarPuntolvl4_2(String keysacarPuntolvl4_2) {
          this.keysacarPuntolvl4_2 = keysacarPuntolvl4_2;
     }

     public String getKeysacarPuntolvl4_1() {
          return keysacarPuntolvl4_1;
     }

     public void setKeysacarPuntolvl4_1(String keysacarPuntolvl4_1) {
          this.keysacarPuntolvl4_1 = keysacarPuntolvl4_1;
     }

     public String getKeyPuntosV4_4() {
          return keyPuntosV4_4;
     }

     public void setKeyPuntosV4_4(String keyPuntosV4_4) {
          this.keyPuntosV4_4 = keyPuntosV4_4;
     }

     public String getKeyPuntosV4_3() {
          return keyPuntosV4_3;
     }

     public void setKeyPuntosV4_3(String keyPuntosV4_3) {
          this.keyPuntosV4_3 = keyPuntosV4_3;
     }

     public String getKeyPuntosV4_2() {
          return keyPuntosV4_2;
     }

     public void setKeyPuntosV4_2(String keyPuntosV4_2) {
          this.keyPuntosV4_2 = keyPuntosV4_2;
     }

     public String getKeyPuntosV4_1() {
          return keyPuntosV4_1;
     }

     public void setKeyPuntosV4_1(String keyPuntosV4_1) {
          this.keyPuntosV4_1 = keyPuntosV4_1;
     }

     public String getKeyEstado10() {
          return keyEstado10;
     }

     public void setKeyEstado10(String keyEstado10) {
          this.keyEstado10 = keyEstado10;
     }

     public String getKeyEstado9() {
          return keyEstado9;
     }

     public void setKeyEstado9(String keyEstado9) {
          this.keyEstado9 = keyEstado9;
     }

     public String getKeyEstado8() {
          return keyEstado8;
     }

     public void setKeyEstado8(String keyEstado8) {
          this.keyEstado8 = keyEstado8;
     }

     public String getKeyEstado7() {
          return keyEstado7;
     }

     public void setKeyEstado7(String keyEstado7) {
          this.keyEstado7 = keyEstado7;
     }

     public String getKeyEstado6() {
          return keyEstado6;
     }

     public void setKeyEstado6(String keyEstado6) {
          this.keyEstado6 = keyEstado6;
     }

     public String getKeyEstado5() {
          return keyEstado5;
     }

     public void setKeyEstado5(String keyEstado5) {
          this.keyEstado5 = keyEstado5;
     }

     public String getKeydueloFinal() {
          return keydueloFinal;
     }

     public void setKeydueloFinal(String keydueloFinal) {
          this.keydueloFinal = keydueloFinal;
     }

     public String getKeyEstado4() {
          return keyEstado4;
     }

     public void setKeyEstado4(String keyEstado4) {
          this.keyEstado4 = keyEstado4;
     }

     public String getKeyEstado3() {
          return keyEstado3;
     }

     public void setKeyEstado3(String keyEstado3) {
          this.keyEstado3 = keyEstado3;
     }

     public String getKeyEstado2() {
          return keyEstado2;
     }

     public void setKeyEstado2(String keyEstado2) {
          this.keyEstado2 = keyEstado2;
     }

     public String getKeyEstado1() {
          return keyEstado1;
     }

     public void setKeyEstado1(String keyEstado1) {
          this.keyEstado1 = keyEstado1;
     }

     public String getKeyCodigoVictoria() {
          return keyCodigoVictoria;
     }

     public void setKeyCodigoVictoria(String keyCodigoVictoria) {
          this.keyCodigoVictoria = keyCodigoVictoria;
     }

     public String getKeyCalabozoActivo() {
          return keyCalabozoActivo;
     }

     public void setKeyCalabozoActivo(String keyCalabozoActivo) {
          this.keyCalabozoActivo = keyCalabozoActivo;
     }

     public String getKeyEnlaceCalabozolvl1() {
          return keyEnlaceCalabozolvl1;
     }

     public void setKeyEnlaceCalabozolvl1(String keyEnlaceCalabozolvl1) {
          this.keyEnlaceCalabozolvl1 = keyEnlaceCalabozolvl1;
     }

     public String getKeyEnlaceCalabozolvl2() {
          return keyEnlaceCalabozolvl2;
     }

     public void setKeyEnlaceCalabozolvl2(String keyEnlaceCalabozolvl2) {
          this.keyEnlaceCalabozolvl2 = keyEnlaceCalabozolvl2;
     }

     public String getKeyEnlaceCalabozolvl3() {
          return keyEnlaceCalabozolvl3;
     }

     public void setKeyEnlaceCalabozolvl3(String keyEnlaceCalabozolvl3) {
          this.keyEnlaceCalabozolvl3 = keyEnlaceCalabozolvl3;
     }

     public String getKeyEnlaceCalabozolvl4() {
          return keyEnlaceCalabozolvl4;
     }

     public void setKeyEnlaceCalabozolvl4(String keyEnlaceCalabozolvl4) {
          this.keyEnlaceCalabozolvl4 = keyEnlaceCalabozolvl4;
     }

     public String getKeyEnlaceCalabozolvl5() {
          return keyEnlaceCalabozolvl5;
     }

     public void setKeyEnlaceCalabozolvl5(String keyEnlaceCalabozolvl5) {
          this.keyEnlaceCalabozolvl5 = keyEnlaceCalabozolvl5;
     }

     public String getKeyEnlaceCalabozolvl6() {
          return keyEnlaceCalabozolvl6;
     }

     public void setKeyEnlaceCalabozolvl6(String keyEnlaceCalabozolvl6) {
          this.keyEnlaceCalabozolvl6 = keyEnlaceCalabozolvl6;
     }


     public String getKeyCalabozolvl10() {
          return keyCalabozolvl10;
     }

     public void setKeyCalabozolvl10(String keyCalabozolvl10) {
          this.keyCalabozolvl10 = keyCalabozolvl10;
     }

     public String getKeyCalabozolvl9() {
          return keyCalabozolvl9;
     }

     public void setKeyCalabozolvl9(String keyCalabozolvl9) {
          this.keyCalabozolvl9 = keyCalabozolvl9;
     }

     public String getKeyCalabozolvl8() {
          return keyCalabozolvl8;
     }

     public void setKeyCalabozolvl8(String keyCalabozolvl8) {
          this.keyCalabozolvl8 = keyCalabozolvl8;
     }

     public String getKeyCalabozolvl7() {
          return keyCalabozolvl7;
     }

     public void setKeyCalabozolvl7(String keyCalabozolvl7) {
          this.keyCalabozolvl7 = keyCalabozolvl7;
     }

     public String getKeyCalabozolvl6() {
          return keyCalabozolvl6;
     }

     public void setKeyCalabozolvl6(String keyCalabozolvl6) {
          this.keyCalabozolvl6 = keyCalabozolvl6;
     }

     public String getKeyCalabozolvl5() {
          return keyCalabozolvl5;
     }

     public void setKeyCalabozolvl5(String keyCalabozolvl5) {
          this.keyCalabozolvl5 = keyCalabozolvl5;
     }

     public String getKeyCalabozolvl4() {
          return keyCalabozolvl4;
     }

     public void setKeyCalabozolvl4(String keyCalabozolvl4) {
          this.keyCalabozolvl4 = keyCalabozolvl4;
     }

     public String getKeyCalabozolvl3() {
          return keyCalabozolvl3;
     }

     public void setKeyCalabozolvl3(String keyCalabozolvl3) {
          this.keyCalabozolvl3 = keyCalabozolvl3;
     }

     public String getKeyCalabozolvl2() {
          return keyCalabozolvl2;
     }

     public void setKeyCalabozolvl2(String keyCalabozolvl2) {
          this.keyCalabozolvl2 = keyCalabozolvl2;
     }

     public String getKeyCalabozolvl1() {
          return keyCalabozolvl1;
     }

     public void setKeyCalabozolvl1(String keyCalabozolvl1) {
          this.keyCalabozolvl1 = keyCalabozolvl1;
     }

     public String getKeycEntadaCalabozo() {
          return keycEntadaCalabozo;
     }

     public void setKeycEntadaCalabozo(String keycEntadaCalabozo) {
          this.keycEntadaCalabozo = keycEntadaCalabozo;
     }

     public String getKeyFinalista3() {
          return keyFinalista3;
     }

     public void setKeyFinalista3(String keyFinalista3) {
          this.keyFinalista3 = keyFinalista3;
     }

     public String getKeyFinalista2() {
          return keyFinalista2;
     }

     public void setKeyFinalista2(String keyFinalista2) {
          this.keyFinalista2 = keyFinalista2;
     }

     public String getKeyFinalista1() {
          return keyFinalista1;
     }

     public void setKeyFinalista1(String keyFinalista1) {
          this.keyFinalista1 = keyFinalista1;
     }

     public String getKeySalaDuelo() {
          return keySalaDuelo;
     }

     public void setKeySalaDuelo(String keySalaDuelo) {
          this.keySalaDuelo = keySalaDuelo;
     }

     public String getKeyCodigoReport() {
          return keyCodigoReport;
     }

     public void setKeyCodigoReport(String keyCodigoReport) {
          this.keyCodigoReport = keyCodigoReport;
     }

     public String getKeyFinalPuesto1() {
          return keyFinalPuesto1;
     }

     public void setKeyFinalPuesto1(String keyFinalPuesto1) {
          this.keyFinalPuesto1 = keyFinalPuesto1;
     }

     public String getKeyFinalPuesto2() {
          return keyFinalPuesto2;
     }

     public void setKeyFinalPuesto2(String keyFinalPuesto2) {
          this.keyFinalPuesto2 = keyFinalPuesto2;
     }

     public String getKeyFinalPuesto3() {
          return keyFinalPuesto3;
     }

     public void setKeyFinalPuesto3(String keyFinalPuesto3) {
          this.keyFinalPuesto3 = keyFinalPuesto3;
     }

     public String getKeyFinalPuesto4() {
          return keyFinalPuesto4;
     }

     public void setKeyFinalPuesto4(String keyFinalPuesto4) {
          this.keyFinalPuesto4 = keyFinalPuesto4;
     }

     public String getKeyFinalPuesto5() {
          return keyFinalPuesto5;
     }

     public void setKeyFinalPuesto5(String keyFinalPuesto5) {
          this.keyFinalPuesto5 = keyFinalPuesto5;
     }

     public String getKeyFinalPuesto6() {
          return keyFinalPuesto6;
     }

     public void setKeyFinalPuesto6(String keyFinalPuesto6) {
          this.keyFinalPuesto6 = keyFinalPuesto6;
     }

     public String getKeyFinalPuesto7() {
          return keyFinalPuesto7;
     }

     public void setKeyFinalPuesto7(String keyFinalPuesto7) {
          this.keyFinalPuesto7 = keyFinalPuesto7;
     }

     public String getKeyFinalPuesto8() {
          return keyFinalPuesto8;
     }

     public void setKeyFinalPuesto8(String keyFinalPuesto8) {
          this.keyFinalPuesto8 = keyFinalPuesto8;
     }

     public String getKeyFinalPuesto9() {
          return keyFinalPuesto9;
     }

     public void setKeyFinalPuesto9(String keyFinalPuesto9) {
          this.keyFinalPuesto9 = keyFinalPuesto9;
     }

     public String getKeyFinalPuesto10() {
          return keyFinalPuesto10;
     }

     public void setKeyFinalPuesto10(String keyFinalPuesto10) {
          this.keyFinalPuesto10 = keyFinalPuesto10;
     }

     public String getKeyFinalPuesto11() {
          return keyFinalPuesto11;
     }

     public void setKeyFinalPuesto11(String keyFinalPuesto11) {
          this.keyFinalPuesto11 = keyFinalPuesto11;
     }

     public String getKeyFinalPuesto12() {
          return keyFinalPuesto12;
     }

     public void setKeyFinalPuesto12(String keyFinalPuesto12) {
          this.keyFinalPuesto12 = keyFinalPuesto12;
     }

     public String getKeyLugarFinal4() {
          return keyLugarFinal4;
     }

     public void setKeyLugarFinal4(String keyLugarFinal4) {
          this.keyLugarFinal4 = keyLugarFinal4;
     }

     public String getKeyLugarFinal5() {
          return keyLugarFinal5;
     }

     public void setKeyLugarFinal5(String keyLugarFinal5) {
          this.keyLugarFinal5 = keyLugarFinal5;
     }

     public String getKeyLugarFinal6() {
          return keyLugarFinal6;
     }

     public void setKeyLugarFinal6(String keyLugarFinal6) {
          this.keyLugarFinal6 = keyLugarFinal6;
     }

     public String getKeyLugarFinal7() {
          return keyLugarFinal7;
     }

     public void setKeyLugarFinal7(String keyLugarFinal7) {
          this.keyLugarFinal7 = keyLugarFinal7;
     }

     public String getKeyLugarFinal8() {
          return keyLugarFinal8;
     }

     public void setKeyLugarFinal8(String keyLugarFinal8) {
          this.keyLugarFinal8 = keyLugarFinal8;
     }

     public String getKeyLugarFinal9() {
          return keyLugarFinal9;
     }

     public void setKeyLugarFinal9(String keyLugarFinal9) {
          this.keyLugarFinal9 = keyLugarFinal9;
     }

     public String getKeyLugarFinal10() {
          return keyLugarFinal10;
     }

     public void setKeyLugarFinal10(String keyLugarFinal10) {
          this.keyLugarFinal10 = keyLugarFinal10;
     }

     public String getKeyLugarFinal11() {
          return keyLugarFinal11;
     }

     public void setKeyLugarFinal11(String keyLugarFinal11) {
          this.keyLugarFinal11 = keyLugarFinal11;
     }

     public String getKeyLugarFinal12() {
          return keyLugarFinal12;
     }

     public void setKeyLugarFinal12(String keyLugarFinal12) {
          this.keyLugarFinal12 = keyLugarFinal12;
     }

     public String getKeyLugarFinal3() {
          return keyLugarFinal3;
     }

     public void setKeyLugarFinal3(String keyLugarFinal3) {
          this.keyLugarFinal3 = keyLugarFinal3;
     }

     public String getKeyLugarFinal2() {
          return keyLugarFinal2;
     }

     public void setKeyLugarFinal2(String keyLugarFinal2) {
          this.keyLugarFinal2 = keyLugarFinal2;
     }

     public String getKeyLugarFinal1() {
          return keyLugarFinal1;
     }

     public void setKeyLugarFinal1(String keyLugarFinal1) {
          this.keyLugarFinal1 = keyLugarFinal1;
     }

     public String getKeyVideoActivo1() {
          return keyVideoActivo1;
     }

     public void setKeyVideoActivo1(String keyVideoActivo1) {
          this.keyVideoActivo1 = keyVideoActivo1;
     }

     public String getKeyVideoActivo2() {
          return keyVideoActivo2;
     }

     public void setKeyVideoActivo2(String keyVideoActivo2) {
          this.keyVideoActivo2 = keyVideoActivo2;
     }

     public String getKeyVideoActivo3() {
          return keyVideoActivo3;
     }

     public void setKeyVideoActivo3(String keyVideoActivo3) {
          this.keyVideoActivo3 = keyVideoActivo3;
     }

     public String getKeyVideoActivo4() {
          return keyVideoActivo4;
     }

     public void setKeyVideoActivo4(String keyVideoActivo4) {
          this.keyVideoActivo4 = keyVideoActivo4;
     }

     public String getKeyRegistroActivo() {
          return keyRegistroActivo;
     }

     public void setKeyRegistroActivo(String keyRegistroActivo) {
          this.keyRegistroActivo = keyRegistroActivo;
     }



     public String getKeySalaAdmin() {
          return keySalaAdmin;
     }

     public void setKeySalaAdmin(String keySalaAdmin) {
          this.keySalaAdmin = keySalaAdmin;
     }

     public String getKeyAdmonEncuentro1() {
          return keyAdmonEncuentro1;
     }

     public void setKeyAdmonEncuentro1(String keyAdmonEncuentro1) {
          this.keyAdmonEncuentro1 = keyAdmonEncuentro1;
     }

     public String getKeyAdmonEncuentro2() {
          return keyAdmonEncuentro2;
     }

     public void setKeyAdmonEncuentro2(String keyAdmonEncuentro2) {
          this.keyAdmonEncuentro2 = keyAdmonEncuentro2;
     }

     public String getKeyTier1() {
          return keyTier1;
     }

     public void setKeyTier1(String keyTier1) {
          this.keyTier1 = keyTier1;
     }

     public String getKeyTier2() {
          return keyTier2;
     }

     public void setKeyTier2(String keyTier2) {
          this.keyTier2 = keyTier2;
     }

     public String getKeyTier3() {
          return keyTier3;
     }

     public void setKeyTier3(String keyTier3) {
          this.keyTier3 = keyTier3;
     }

     public String getKeyFinalista01() {
          return keyFinalista01;
     }

     public void setKeyFinalista01(String keyFinalista01) {
          this.keyFinalista01 = keyFinalista01;
     }

     public String getKeyFinalista02() {
          return keyFinalista02;
     }

     public void setKeyFinalista02(String keyFinalista02) {
          this.keyFinalista02 = keyFinalista02;
     }

     public String getKeyFinalista03() {
          return keyFinalista03;
     }

     public void setKeyFinalista03(String keyFinalista03) {
          this.keyFinalista03 = keyFinalista03;
     }

     public String getKeyFinalista04() {
          return keyFinalista04;
     }

     public void setKeyFinalista04(String keyFinalista04) {
          this.keyFinalista04 = keyFinalista04;
     }

     public String getKeyFinalista05() {
          return keyFinalista05;
     }

     public void setKeyFinalista05(String keyFinalista05) {
          this.keyFinalista05 = keyFinalista05;
     }

     public String getKeyFinalista06() {
          return keyFinalista06;
     }

     public void setKeyFinalista06(String keyFinalista06) {
          this.keyFinalista06 = keyFinalista06;
     }

     public String getKeyFinalista07() {
          return keyFinalista07;
     }

     public void setKeyFinalista07(String keyFinalista07) {
          this.keyFinalista07 = keyFinalista07;
     }

     public String getKeyFinalista08() {
          return keyFinalista08;
     }

     public void setKeyFinalista08(String keyFinalista08) {
          this.keyFinalista08 = keyFinalista08;
     }

     public String getKeyFinalista09() {
          return keyFinalista09;
     }

     public void setKeyFinalista09(String keyFinalista09) {
          this.keyFinalista09 = keyFinalista09;
     }

     public String getKeyFinalista10() {
          return keyFinalista10;
     }

     public void setKeyFinalista10(String keyFinalista10) {
          this.keyFinalista10 = keyFinalista10;
     }

     public String getKeyFinalista11() {
          return keyFinalista11;
     }

     public void setKeyFinalista11(String keyFinalista11) {
          this.keyFinalista11 = keyFinalista11;
     }

     public String getKeyFinalista12() {
          return keyFinalista12;
     }

     public void setKeyFinalista12(String keyFinalista12) {
          this.keyFinalista12 = keyFinalista12;
     }

     public String getKeyTorneoActivo() {
          return keyTorneoActivo;
     }

     public void setKeyTorneoActivo(String keyTorneoActivo) {
          this.keyTorneoActivo = keyTorneoActivo;
     }

     public String getKeySalaActiva() {
          return keySalaActiva;
     }

     public void setKeySalaActiva(String keySalaActiva) {
          this.keySalaActiva = keySalaActiva;
     }

     public String getKeyActivacionRamdom() {
          return keyActivacionRamdom;
     }

     public void setKeyActivacionRamdom(String keyActivacionRamdom) {
          this.keyActivacionRamdom = keyActivacionRamdom;
     }

     public String getKeyRutaDungeon1() {
          return keyRutaDungeon1;
     }

     public void setKeyRutaDungeon1(String keyRutaDungeon1) {
          this.keyRutaDungeon1 = keyRutaDungeon1;
     }

     public String getKeyRutaDungeon2() {
          return keyRutaDungeon2;
     }

     public void setKeyRutaDungeon2(String keyRutaDungeon2) {
          this.keyRutaDungeon2 = keyRutaDungeon2;
     }

    public String getKeyEstado11() {
        return keyEstado11;
    }

    public void setKeyEstado11(String keyEstado11) {
        this.keyEstado11 = keyEstado11;
    }

    public String getKeyEstado12() {
        return keyEstado12;
    }

    public void setKeyEstado12(String keyEstado12) {
        this.keyEstado12 = keyEstado12;
    }

     public String getKeyParticipante11() {
          return keyParticipante11;
     }

     public void setKeyParticipante11(String keyParticipante11) {
          this.keyParticipante11 = keyParticipante11;
     }

     public String getKeyParticipante12() {
          return keyParticipante12;
     }

     public void setKeyParticipante12(String keyParticipante12) {
          this.keyParticipante12 = keyParticipante12;
     }

     public String getKeyPuntosV4_11() {
          return keyPuntosV4_11;
     }

     public void setKeyPuntosV4_11(String keyPuntosV4_11) {
          this.keyPuntosV4_11 = keyPuntosV4_11;
     }

     public String getKeyPuntosV4_12() {
          return keyPuntosV4_12;
     }

     public void setKeyPuntosV4_12(String keyPuntosV4_12) {
          this.keyPuntosV4_12 = keyPuntosV4_12;
     }

     public String getKeyTablaGeneral() {
          return keyTablaGeneral;
     }

     public void setKeyTablaGeneral(String keyTablaGeneral) {
          this.keyTablaGeneral = keyTablaGeneral;
     }

     public String getKeyTorneo1() {
          return keyTorneo1;
     }

     public void setKeyTorneo1(String keyTorneo1) {
          this.keyTorneo1 = keyTorneo1;
     }

     public String getKeyTorneo3() {
          return keyTorneo3;
     }

     public void setKeyTorneo3(String keyTorneo3) {
          this.keyTorneo3 = keyTorneo3;
     }

     public String getKeyTorneo2() {
          return keyTorneo2;
     }

     public void setKeyTorneo2(String keyTorneo2) {
          this.keyTorneo2 = keyTorneo2;
     }

    public String getKeyParticipanteEspera1() {
        return keyParticipanteEspera1;
    }

    public void setKeyParticipanteEspera1(String keyParticipanteEspera1) {
        this.keyParticipanteEspera1 = keyParticipanteEspera1;
    }

    public String getKeyParticipanteEspera2() {
        return keyParticipanteEspera2;
    }

    public void setKeyParticipanteEspera2(String keyParticipanteEspera2) {
        this.keyParticipanteEspera2 = keyParticipanteEspera2;
    }

    public String getKeyParticipanteEspera3() {
        return keyParticipanteEspera3;
    }

    public void setKeyParticipanteEspera3(String keyParticipanteEspera3) {
        this.keyParticipanteEspera3 = keyParticipanteEspera3;
    }

    public String getKeyParticipanteEspera4() {
        return keyParticipanteEspera4;
    }

    public void setKeyParticipanteEspera4(String keyParticipanteEspera4) {
        this.keyParticipanteEspera4 = keyParticipanteEspera4;
    }

    public String getKeyParticipanteEspera5() {
        return keyParticipanteEspera5;
    }

    public void setKeyParticipanteEspera5(String keyParticipanteEspera5) {
        this.keyParticipanteEspera5 = keyParticipanteEspera5;
    }

    public String getKeyParticipanteEspera6() {
        return keyParticipanteEspera6;
    }

    public void setKeyParticipanteEspera6(String keyParticipanteEspera6) {
        this.keyParticipanteEspera6 = keyParticipanteEspera6;
    }

    public String getKeyParticipanteEspera7() {
        return keyParticipanteEspera7;
    }

    public void setKeyParticipanteEspera7(String keyParticipanteEspera7) {
        this.keyParticipanteEspera7 = keyParticipanteEspera7;
    }

    public String getKeyParticipanteEspera8() {
        return keyParticipanteEspera8;
    }

    public void setKeyParticipanteEspera8(String keyParticipanteEspera8) {
        this.keyParticipanteEspera8 = keyParticipanteEspera8;
    }

    public String getKeyParticipanteEspera9() {
        return keyParticipanteEspera9;
    }

    public void setKeyParticipanteEspera9(String keyParticipanteEspera9) {
        this.keyParticipanteEspera9 = keyParticipanteEspera9;
    }

    public String getKeyParticipanteEspera10() {
        return keyParticipanteEspera10;
    }

    public void setKeyParticipanteEspera10(String keyParticipanteEspera10) {
        this.keyParticipanteEspera10 = keyParticipanteEspera10;
    }

    public String getKeyParticipanteEspera11() {
        return keyParticipanteEspera11;
    }

    public void setKeyParticipanteEspera11(String keyParticipanteEspera11) {
        this.keyParticipanteEspera11 = keyParticipanteEspera11;
    }

    public String getKeyParticipanteEspera12() {
        return keyParticipanteEspera12;
    }

    public void setKeyParticipanteEspera12(String keyParticipanteEspera12) {
        this.keyParticipanteEspera12 = keyParticipanteEspera12;
    }

     public String getKeyPuntosEspera1() {
          return keyPuntosEspera1;
     }

     public void setKeyPuntosEspera1(String keyPuntosEspera1) {
          this.keyPuntosEspera1 = keyPuntosEspera1;
     }

    public String getKeyPuntosEspera2() {
        return keyPuntosEspera2;
    }

    public void setKeyPuntosEspera2(String keyPuntosEspera2) {
        this.keyPuntosEspera2 = keyPuntosEspera2;
    }

    public String getKeyPuntosEspera3() {
        return keyPuntosEspera3;
    }

    public void setKeyPuntosEspera3(String keyPuntosEspera3) {
        this.keyPuntosEspera3 = keyPuntosEspera3;
    }

    public String getKeyPuntosEspera4() {
        return keyPuntosEspera4;
    }

    public void setKeyPuntosEspera4(String keyPuntosEspera4) {
        this.keyPuntosEspera4 = keyPuntosEspera4;
    }

    public String getKeyPuntosEspera5() {
        return keyPuntosEspera5;
    }

    public void setKeyPuntosEspera5(String keyPuntosEspera5) {
        this.keyPuntosEspera5 = keyPuntosEspera5;
    }

    public String getKeyPuntosEspera6() {
        return keyPuntosEspera6;
    }

    public void setKeyPuntosEspera6(String keyPuntosEspera6) {
        this.keyPuntosEspera6 = keyPuntosEspera6;
    }

    public String getKeyPuntosEspera8() {
        return keyPuntosEspera8;
    }

    public void setKeyPuntosEspera8(String keyPuntosEspera8) {
        this.keyPuntosEspera8 = keyPuntosEspera8;
    }

    public String getKeyPuntosEspera7() {
        return keyPuntosEspera7;
    }

    public void setKeyPuntosEspera7(String keyPuntosEspera7) {
        this.keyPuntosEspera7 = keyPuntosEspera7;
    }

    public String getKeyPuntosEspera9() {
        return keyPuntosEspera9;
    }

    public void setKeyPuntosEspera9(String keyPuntosEspera9) {
        this.keyPuntosEspera9 = keyPuntosEspera9;
    }

    public String getKeyPuntosEspera10() {
        return keyPuntosEspera10;
    }

    public void setKeyPuntosEspera10(String keyPuntosEspera10) {
        this.keyPuntosEspera10 = keyPuntosEspera10;
    }

    public String getKeyTotalPuntoEspera1() {
        return keyTotalPuntoEspera1;
    }

    public void setKeyTotalPuntoEspera1(String keyTotalPuntoEspera1) {
        this.keyTotalPuntoEspera1 = keyTotalPuntoEspera1;
    }

    public String getKeyTotalPuntoEspera2() {
        return keyTotalPuntoEspera2;
    }

    public void setKeyTotalPuntoEspera2(String keyTotalPuntoEspera2) {
        this.keyTotalPuntoEspera2 = keyTotalPuntoEspera2;
    }

    public String getKeyTotalPuntoEspera3() {
        return keyTotalPuntoEspera3;
    }

    public void setKeyTotalPuntoEspera3(String keyTotalPuntoEspera3) {
        this.keyTotalPuntoEspera3 = keyTotalPuntoEspera3;
    }

    public String getKeyTotalPuntoEspera4() {
        return keyTotalPuntoEspera4;
    }

    public void setKeyTotalPuntoEspera4(String keyTotalPuntoEspera4) {
        this.keyTotalPuntoEspera4 = keyTotalPuntoEspera4;
    }

    public String getKeyTotalPuntoEspera5() {
        return keyTotalPuntoEspera5;
    }

    public void setKeyTotalPuntoEspera5(String keyTotalPuntoEspera5) {
        this.keyTotalPuntoEspera5 = keyTotalPuntoEspera5;
    }

    public String getKeyTotalPuntoEspera6() {
        return keyTotalPuntoEspera6;
    }

    public void setKeyTotalPuntoEspera6(String keyTotalPuntoEspera6) {
        this.keyTotalPuntoEspera6 = keyTotalPuntoEspera6;
    }

    public String getKeyTotalPuntoEspera7() {
        return keyTotalPuntoEspera7;
    }

    public void setKeyTotalPuntoEspera7(String keyTotalPuntoEspera7) {
        this.keyTotalPuntoEspera7 = keyTotalPuntoEspera7;
    }

    public String getKeyTotalPuntoEspera8() {
        return keyTotalPuntoEspera8;
    }

    public void setKeyTotalPuntoEspera8(String keyTotalPuntoEspera8) {
        this.keyTotalPuntoEspera8 = keyTotalPuntoEspera8;
    }

    public String getKeyTotalPuntoEspera9() {
        return keyTotalPuntoEspera9;
    }

    public void setKeyTotalPuntoEspera9(String keyTotalPuntoEspera9) {
        this.keyTotalPuntoEspera9 = keyTotalPuntoEspera9;
    }

    public String getKeyTotalPuntoEspera10() {
        return keyTotalPuntoEspera10;
    }

    public void setKeyTotalPuntoEspera10(String keyTotalPuntoEspera10) {
        this.keyTotalPuntoEspera10 = keyTotalPuntoEspera10;
    }

    public String getKeyParticipanteLose1() {
        return keyParticipanteLose1;
    }

    public void setKeyParticipanteLose1(String keyParticipanteLose1) {
        this.keyParticipanteLose1 = keyParticipanteLose1;
    }

    public String getKeyParticipanteLose2() {
        return keyParticipanteLose2;
    }

    public void setKeyParticipanteLose2(String keyParticipanteLose2) {
        this.keyParticipanteLose2 = keyParticipanteLose2;
    }

    public String getKeyParticipanteLose3() {
        return keyParticipanteLose3;
    }

    public void setKeyParticipanteLose3(String keyParticipanteLose3) {
        this.keyParticipanteLose3 = keyParticipanteLose3;
    }

    public String getKeyParticipanteLose4() {
        return keyParticipanteLose4;
    }

    public void setKeyParticipanteLose4(String keyParticipanteLose4) {
        this.keyParticipanteLose4 = keyParticipanteLose4;
    }

    public String getKeyParticipanteLose5() {
        return keyParticipanteLose5;
    }

    public void setKeyParticipanteLose5(String keyParticipanteLose5) {
        this.keyParticipanteLose5 = keyParticipanteLose5;
    }

    public String getKeyParticipanteLose6() {
        return keyParticipanteLose6;
    }

    public void setKeyParticipanteLose6(String keyParticipanteLose6) {
        this.keyParticipanteLose6 = keyParticipanteLose6;
    }

    public String getKeyParticipanteLose7() {
        return keyParticipanteLose7;
    }

    public void setKeyParticipanteLose7(String keyParticipanteLose7) {
        this.keyParticipanteLose7 = keyParticipanteLose7;
    }

    public String getKeyParticipanteLose8() {
        return keyParticipanteLose8;
    }

    public void setKeyParticipanteLose8(String keyParticipanteLose8) {
        this.keyParticipanteLose8 = keyParticipanteLose8;
    }

    public String getKeyParticipanteLose9() {
        return keyParticipanteLose9;
    }

    public void setKeyParticipanteLose9(String keyParticipanteLose9) {
        this.keyParticipanteLose9 = keyParticipanteLose9;
    }

    public String getKeyParticipanteLose10() {
        return keyParticipanteLose10;
    }

    public void setKeyParticipanteLose10(String keyParticipanteLose10) {
        this.keyParticipanteLose10 = keyParticipanteLose10;
    }

    public String getKeyParticipanteLose11() {
        return keyParticipanteLose11;
    }

    public void setKeyParticipanteLose11(String keyParticipanteLose11) {
        this.keyParticipanteLose11 = keyParticipanteLose11;
    }

    public String getKeyCalabozolvl12() {
        return keyCalabozolvl12;
    }

    public void setKeyCalabozolvl12(String keyCalabozolvl12) {
        this.keyCalabozolvl12 = keyCalabozolvl12;
    }

    public String getKeyCalabozolvl11() {
        return keyCalabozolvl11;
    }

    public void setKeyCalabozolvl11(String keyCalabozolvl11) {
        this.keyCalabozolvl11 = keyCalabozolvl11;
    }

    public String getKeyEntradaLose() {
        return keyEntradaLose;
    }

    public void setKeyEntradaLose(String keyEntradaLose) {
        this.keyEntradaLose = keyEntradaLose;
    }

    public String getKeySystemPs1() {
        return keySystemPs1;
    }

    public void setKeySystemPs1(String keySystemPs1) {
        this.keySystemPs1 = keySystemPs1;
    }

    public String getKeySystemPs2() {
        return keySystemPs2;
    }

    public void setKeySystemPs2(String keySystemPs2) {
        this.keySystemPs2 = keySystemPs2;
    }

    public String getKeySystemPs3() {
        return keySystemPs3;
    }

    public void setKeySystemPs3(String keySystemPs3) {
        this.keySystemPs3 = keySystemPs3;
    }

    public String getKeySystemPsG() {
        return keySystemPsG;
    }

    public void setKeySystemPsG(String keySystemPsG) {
        this.keySystemPsG = keySystemPsG;
    }

     public String getKeyCalabozoAtivoLose() {
          return keyCalabozoAtivoLose;
     }

     public void setKeyCalabozoAtivoLose(String keyCalabozoAtivoLose) {
          this.keyCalabozoAtivoLose = keyCalabozoAtivoLose;
     }

     public String getKeyidClan1() {
          return keyidClan1;
     }

     public void setKeyidClan1(String keyidClan1) {
          this.keyidClan1 = keyidClan1;
     }

     public String getKeyidClan2() {
          return keyidClan2;
     }

     public void setKeyidClan2(String keyidClan2) {
          this.keyidClan2 = keyidClan2;
     }

     public String getKeyidClan3() {
          return keyidClan3;
     }

     public void setKeyidClan3(String keyidClan3) {
          this.keyidClan3 = keyidClan3;
     }

     public String getKeyidClan4() {
          return keyidClan4;
     }

     public void setKeyidClan4(String keyidClan4) {
          this.keyidClan4 = keyidClan4;
     }

     public String getKeyidClan5() {
          return keyidClan5;
     }

     public void setKeyidClan5(String keyidClan5) {
          this.keyidClan5 = keyidClan5;
     }

     public String getKeyidClan6() {
          return keyidClan6;
     }

     public void setKeyidClan6(String keyidClan6) {
          this.keyidClan6 = keyidClan6;
     }

    public String getKeyParticipanteLose12() {
        return keyParticipanteLose12;
    }

    public void setKeyParticipanteLose12(String keyParticipanteLose12) {
        this.keyParticipanteLose12 = keyParticipanteLose12;
    }

     public String getKeyExclucion() {
          return keyExclucion;
     }

     public void setKeyExclucion(String keyExclucion) {
          this.keyExclucion = keyExclucion;
     }

     public String getKeyConteo() {
          return keyConteo;
     }

     public void setKeyConteo(String keyConteo) {
          this.keyConteo = keyConteo;
     }

     public String getKeyFormatoImgagen() {
          return keyFormatoImgagen;
     }

     public void setKeyFormatoImgagen(String keyFormatoImgagen) {
          this.keyFormatoImgagen = keyFormatoImgagen;
     }

     public String getKeyTotalDerrotasLose() {
          return keyTotalDerrotasLose;
     }

     public void setKeyTotalDerrotasLose(String keyTotalDerrotasLose) {
          this.keyTotalDerrotasLose = keyTotalDerrotasLose;
     }

     public String getKeyTotalVictoriasLose() {
          return keyTotalVictoriasLose;
     }

     public void setKeyTotalVictoriasLose(String keyTotalVictoriasLose) {
          this.keyTotalVictoriasLose = keyTotalVictoriasLose;
     }


     public String getKeyTime1Main() {
          return keyTime1Main;
     }

     public void setKeyTime1Main(String keyTime1Main) {
          this.keyTime1Main = keyTime1Main;
     }

     public String getKeyTime2Main() {
          return keyTime2Main;
     }

     public void setKeyTime2Main(String keyTime2Main) {
          this.keyTime2Main = keyTime2Main;
     }

     public String getKeyN() {
          return keyN;
     }

     public void setKeyN(String keyN) {
          this.keyN = keyN;
     }

    public String getKeyEquipo2() {
        return keyEquipo2;
    }

    public void setKeyEquipo2(String keyEquipo2) {
        this.keyEquipo2 = keyEquipo2;
    }

    public String getKeyEquipo1() {
        return keyEquipo1;
    }

    public void setKeyEquipo1(String keyEquipo1) {
        this.keyEquipo1 = keyEquipo1;
    }

    public String getKeyEquipo3() {
        return keyEquipo3;
    }

    public void setKeyEquipo3(String keyEquipo3) {
        this.keyEquipo3 = keyEquipo3;
    }

    public String getKeyEquipo4() {
        return keyEquipo4;
    }

    public void setKeyEquipo4(String keyEquipo4) {
        this.keyEquipo4 = keyEquipo4;
    }

    public String getKeyEquipo5() {
        return keyEquipo5;
    }

    public void setKeyEquipo5(String keyEquipo5) {
        this.keyEquipo5 = keyEquipo5;
    }

    public String getKeyEquipo6() {
        return keyEquipo6;
    }

    public void setKeyEquipo6(String keyEquipo6) {
        this.keyEquipo6 = keyEquipo6;
    }

    public String getKeyEquipo7() {
        return keyEquipo7;
    }

    public void setKeyEquipo7(String keyEquipo7) {
        this.keyEquipo7 = keyEquipo7;
    }

    public String getKeyEquipo8() {
        return keyEquipo8;
    }

    public void setKeyEquipo8(String keyEquipo8) {
        this.keyEquipo8 = keyEquipo8;
    }

    public String getKeyEquipo9() {
        return keyEquipo9;
    }

    public void setKeyEquipo9(String keyEquipo9) {
        this.keyEquipo9 = keyEquipo9;
    }

    public String getKeyEquipo10() {
        return keyEquipo10;
    }

    public void setKeyEquipo10(String keyEquipo10) {
        this.keyEquipo10 = keyEquipo10;
    }

     public String getKeyfechasUnder() {
          return keyfechasUnder;
     }

     public void setKeyfechasUnder(String keyfechasUnder) {
          this.keyfechasUnder = keyfechasUnder;
     }

     public String getKeyfechasUnder2() {
          return keyfechasUnder2;
     }

     public void setKeyfechasUnder2(String keyfechasUnder2) {
          this.keyfechasUnder2 = keyfechasUnder2;
     }

     public String getKeyEstadoUnder1() {
          return keyEstadoUnder1;
     }

     public void setKeyEstadoUnder1(String keyEstadoUnder1) {
          this.keyEstadoUnder1 = keyEstadoUnder1;
     }

     public String getKeyEstadoUnder2() {
          return keyEstadoUnder2;
     }

     public void setKeyEstadoUnder2(String keyEstadoUnder2) {
          this.keyEstadoUnder2 = keyEstadoUnder2;
     }

     public String getKeyEncuentro1() {
          return keyEncuentro1;
     }

     public void setKeyEncuentro1(String keyEncuentro1) {
          this.keyEncuentro1 = keyEncuentro1;
     }

     public String getKeyEncuentro2() {
          return keyEncuentro2;
     }

     public void setKeyEncuentro2(String keyEncuentro2) {
          this.keyEncuentro2 = keyEncuentro2;
     }

     public String getKeyNGrupos() {
          return keyNGrupos;
     }

     public void setKeyNGrupos(String keyNGrupos) {
          this.keyNGrupos = keyNGrupos;
     }

     public String getKeyVsEquipo1() {
          return keyVsEquipo1;
     }

     public void setKeyVsEquipo1(String keyVsEquipo1) {
          this.keyVsEquipo1 = keyVsEquipo1;
     }

     public String getKeyVsEquipo2() {
          return keyVsEquipo2;
     }

     public void setKeyVsEquipo2(String keyVsEquipo2) {
          this.keyVsEquipo2 = keyVsEquipo2;
     }

     public String getKeyVsEquipo3() {
          return keyVsEquipo3;
     }

     public void setKeyVsEquipo3(String keyVsEquipo3) {
          this.keyVsEquipo3 = keyVsEquipo3;
     }

     public String getKeyVsEquipo4() {
          return keyVsEquipo4;
     }

     public void setKeyVsEquipo4(String keyVsEquipo4) {
          this.keyVsEquipo4 = keyVsEquipo4;
     }

     public String getKeyVsEquipo5() {
          return keyVsEquipo5;
     }

     public void setKeyVsEquipo5(String keyVsEquipo5) {
          this.keyVsEquipo5 = keyVsEquipo5;
     }

     public String getKeyVsEquipo6() {
          return keyVsEquipo6;
     }

     public void setKeyVsEquipo6(String keyVsEquipo6) {
          this.keyVsEquipo6 = keyVsEquipo6;
     }

     public String getKeyResultReport() {
          return keyResultReport;
     }

     public void setKeyResultReport(String keyResultReport) {
          this.keyResultReport = keyResultReport;
     }

     public String getKeyEleccionTorneoReport() {
          return keyEleccionTorneoReport;
     }

     public void setKeyEleccionTorneoReport(String keyEleccionTorneoReport) {
          this.keyEleccionTorneoReport = keyEleccionTorneoReport;
     }

     public String getKeyCodeReport() {
          return keyCodeReport;
     }

     public void setKeyCodeReport(String keyCodeReport) {
          this.keyCodeReport = keyCodeReport;
     }

     public String getKeyVerificReport() {
          return keyVerificReport;
     }

     public void setKeyVerificReport(String keyVerificReport) {
          this.keyVerificReport = keyVerificReport;
     }

     public String getKeyEquipoUnder_1() {
          return keyEquipoUnder_1;
     }

     public void setKeyEquipoUnder_1(String keyEquipoUnder_1) {
          this.keyEquipoUnder_1 = keyEquipoUnder_1;
     }

     public String getKeyconteoUnder() {
          return keyconteoUnder;
     }

     public void setKeyconteoUnder(String keyconteoUnder) {
          this.keyconteoUnder = keyconteoUnder;
     }

     public String getKeyEquipoUnder_2() {
          return keyEquipoUnder_2;
     }

     public void setKeyEquipoUnder_2(String keyEquipoUnder_2) {
          this.keyEquipoUnder_2 = keyEquipoUnder_2;
     }

     public String getKeyVerificationReport_1() {
          return keyVerificationReport_1;
     }

     public void setKeyVerificationReport_1(String keyVerificationReport_1) {
          this.keyVerificationReport_1 = keyVerificationReport_1;
     }

     public String getEyVerificaionReport_2() {
          return eyVerificaionReport_2;
     }

     public void setEyVerificaionReport_2(String eyVerificaionReport_2) {
          this.eyVerificaionReport_2 = eyVerificaionReport_2;
     }

     public String getKeyUnderFases() {
          return keyUnderFases;
     }

     public void setKeyUnderFases(String keyUnderFases) {
          this.keyUnderFases = keyUnderFases;
     }

     public String getKeyUnderGrup1() {
          return keyUnderGrup1;
     }

     public void setKeyUnderGrup1(String keyUnderGrup1) {
          this.keyUnderGrup1 = keyUnderGrup1;
     }

     public String getKeyUnderGrup2() {
          return keyUnderGrup2;
     }

     public void setKeyUnderGrup2(String keyUnderGrup2) {
          this.keyUnderGrup2 = keyUnderGrup2;
     }

     public String getKeyGrupoN1() {
          return keyGrupoN1;
     }

     public void setKeyGrupoN1(String keyGrupoN1) {
          this.keyGrupoN1 = keyGrupoN1;
     }

     public String getKeyGrupoN2() {
          return keyGrupoN2;
     }

     public void setKeyGrupoN2(String keyGrupoN2) {
          this.keyGrupoN2 = keyGrupoN2;
     }

     public String getKeyGrupoN3() {
          return keyGrupoN3;
     }

     public void setKeyGrupoN3(String keyGrupoN3) {
          this.keyGrupoN3 = keyGrupoN3;
     }

     public String getKeyGrupoN4() {
          return keyGrupoN4;
     }

     public void setKeyGrupoN4(String keyGrupoN4) {
          this.keyGrupoN4 = keyGrupoN4;
     }

     public String getKeyGrupoN5() {
          return keyGrupoN5;
     }

     public void setKeyGrupoN5(String keyGrupoN5) {
          this.keyGrupoN5 = keyGrupoN5;
     }

     public String getKeyRadio2() {
          return keyRadio2;
     }

     public void setKeyRadio2(String keyRadio2) {
          this.keyRadio2 = keyRadio2;
     }

     public String getKeyRadio1() {
          return keyRadio1;
     }

     public void setKeyRadio1(String keyRadio1) {
          this.keyRadio1 = keyRadio1;
     }
}
