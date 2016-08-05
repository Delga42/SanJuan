package com.albaitdevs.programasanjuan;

import java.util.ArrayList;

/**
 * Created by Delga on 18/06/2015.
 */
public class SchedulesStatics {

    public static ArrayList<Schedule> list_lacompra =  new ArrayList<Schedule>(){{
        add(new Schedule(R.string.lacompra_titulo, 0, null, 0, true));
        add(new Schedule(R.string.lacompra_0000, R.string.lacompra_0000_detail,R.string.place_plazaherradores,"00:00",0,false));
        add(new Schedule(R.string.lacompra_autobuses, R.string.lacompra_autobuses_detail,R.string.place_lacompra,"07:00 a 22:00",0,false));
        add(new Schedule(R.string.lacompra_0800, R.string.lacompra_0800_detail,R.string.place_valonsadero,"08:00",0,false));
        add(new Schedule(R.string.lacompra_1700, R.string.lacompra_1700_detail,R.string.place_lacompra,"17:00",0,false));
    }};

    private static ArrayList<Schedule> list0 =  new ArrayList<Schedule>(){{
        add(new Schedule(R.string.miercoles_titulo, 0 ,null,0,true));
        add(new Schedule(R.string.miercoles_1800, R.string.miercoles_1800_detail,R.string.place_plazadetoros,"18:00",0,false));
        add(new Schedule(R.string.miercoles_2300, R.string.miercoles_2300_detail,R.string.place_plazamayor_alameda,"23:00",0,false));
        add(new Schedule(R.string.miercoles_2400, R.string.miercoles_2400_detail,R.string.place_plazasdelaciudad,"24:00",0,false));

    }};

    private static ArrayList<Schedule> list1 =  new ArrayList<Schedule>(){{
        add(new Schedule(R.string.jueves_titulo, 0, null, 0, true));
        add(new Schedule(R.string.jueves_0930, R.string.jueves_0930_detail, R.string.place_plazamayor,"09:30", 0, false));
        add(new Schedule(R.string.jueves_1200, R.string.jueves_1200_detail,R.string.place_lasaca,"12:00",0,false));
        add(new Schedule(R.string.jueves_1830, R.string.jueves_1830_detail,R.string.place_plazadetoros,"18:30",0,false));
        add(new Schedule(R.string.jueves_2030, R.string.jueves_2030_detail,R.string.place_plazamayor,"20:30",0,false));
        add(new Schedule(R.string.jueves_2400, R.string.jueves_2400_detail,R.string.place_plazasdelaciudad,"24:00",0,false));

    }};

    private static ArrayList<Schedule> list2 =  new ArrayList<Schedule>(){{
        add(new Schedule(R.string.viernes_titulo, 0, null, 0, true));
        add(new Schedule(R.string.viernes_0800, R.string.viernes_0800_detail,R.string.place_callesdelaciudad,"08:00",0,false));
        add(new Schedule(R.string.viernes_1030, R.string.viernes_1030_detail,R.string.place_plazadetoros,"10:30",0,false));
        add(new Schedule(R.string.viernes_1800, R.string.viernes_1800_detail,R.string.place_plazadetoros,"18:00",0,false));
        add(new Schedule(R.string.viernes_2400, R.string.viernes_2400_detail,R.string.place_plazasdelaciudad,"24:00",0,false));    }};

    private static ArrayList<Schedule> list3 =  new ArrayList<Schedule>(){{
        add(new Schedule(R.string.sabado_titulo, 0, null, 0, true));
        add(new Schedule(R.string.sabado_0800, R.string.sabado_0800_detail,R.string.place_callesdelaciudad,"08:00",0,false));
        add(new Schedule(R.string.sabado_0900, R.string.sabado_0900_detail,R.string.place_localesdecuadrilla,"09:00-13:00",0,false));
        add(new Schedule(R.string.sabado_1300, R.string.sabado_1300_detail,R.string.place_plazadelolivo,"13:00",0,false));
        add(new Schedule(R.string.sabado_1800, R.string.sabado_1800_detail,R.string.place_localesdecuadrilla,"18:00",0,false));
        add(new Schedule(R.string.sabado_1800_corrida, R.string.sabado_1800_corrida_detail,R.string.place_plazadetoros,"18:00",0,false));
        add(new Schedule(R.string.sabado_2300, R.string.sabado_2300_detail,R.string.place_dehesa,"23:00",0,false));
        add(new Schedule(R.string.sabado_2400_baile, R.string.sabado_2400_baile_detail,R.string.place_localesdecuadrilla,"24:00",0,false));
        add(new Schedule(R.string.sabado_2400, R.string.sabado_2400_detail,R.string.place_plazasdelaciudad,"24:00",0,false));


    }};

    private static ArrayList<Schedule> list4 =  new ArrayList<Schedule>(){{
        add(new Schedule(R.string.domingo_titulo, 0, null, 0, true));
        add(new Schedule(R.string.domingo_0700, R.string.domingo_0700_detail,R.string.place_callesdelaciudad,"07:00",0,false));
        add(new Schedule(R.string.domingo_0900_tajada, R.string.domingo_0900_tajada_detail,R.string.place_localesdecuadrilla,"09:00 a 12:00",0,false));
        add(new Schedule(R.string.domingo_1100, R.string.domingo_1100_detail,R.string.place_plazamayor_alameda,"11:00",0,false));
        add(new Schedule(R.string.domingo_1230, R.string.domingo_1230_detail,R.string.place_dehesa,"12:30",0,false));
        add(new Schedule(R.string.domingo_1900, R.string.domingo_1900_detail,R.string.place_plazadetoros,"19:00",0,false));
        add(new Schedule(R.string.domingo_2400, R.string.domingo_2400_detail,R.string.place_plazasdelaciudad,"24:00",0,false));

    }};

    private static ArrayList<Schedule> list5 =  new ArrayList<Schedule>(){{
        add(new Schedule(R.string.lunes_titulo, 0, null, 0, true));
        add(new Schedule(R.string.lunes_0800, R.string.lunes_0800_detail,R.string.place_callesdelaciudad,"08:00",0,false));
        add(new Schedule(R.string.lunes_1030, R.string.lunes_1030_detail,R.string.place_plazamayor_alameda,"10:30",0,false));
        add(new Schedule(R.string.lunes_1700, R.string.lunes_1700_detail,R.string.place_bailas,"17:00",0,false));
        add(new Schedule(R.string.lunes_2230, R.string.lunes_2230_detail,R.string.place_plazamayor_alameda,"22:30",0,false));
        add(new Schedule(R.string.lunes_2400, R.string.lunes_2400_detail,R.string.place_plazamayor_alameda,"24:00",0,false));
        add(new Schedule(R.string.lunes_2400_verbenas, R.string.lunes_2400_verbenas_detail,R.string.place_plazasdelaciudad,"24:00",0,false));
    }};

    public static ArrayList<Schedule> getStaticScheduleLaCompra(){
        return list_lacompra;
    }

    public static ArrayList<Schedule> getStaticScheduleElPregon(){
        return list0;
    }

    public static ArrayList<Schedule> getStaticScheduleLaSaca(){
        return list1;
    }

    public static ArrayList<Schedule> getStaticScheduleLosToros(){
        return list2;
    }

    public static ArrayList<Schedule> getStaticScheduleLosAges(){
        return list3;
    }

    public static ArrayList<Schedule> getStaticScheduleLasCalderas(){
        return list4;
    }

    public static ArrayList<Schedule> getStaticScheduleLasBailas(){
        return list5;
    }

}
