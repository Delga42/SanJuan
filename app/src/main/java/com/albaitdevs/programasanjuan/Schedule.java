package com.albaitdevs.programasanjuan;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Delga on 22/04/2015.
 */

public class Schedule {
    private int title;
    private String time;
    private int place;
    private int information;
    private boolean isSpecial;

    private int timestamp;

    public Schedule(int title, int information, String time, int timestamp, boolean isSpecial) {
        this.title = title;
        this.information = information;
        this.time = time;
        this.timestamp = timestamp;
        this.isSpecial = isSpecial;
        this.place = 0;
    }

    public Schedule(int title, int information, int place, String time, int timestamp, boolean isSpecial) {
        this.title = title;
        this.information = information;
        this.place = place;
        this.time = time;
        this.timestamp = timestamp;
        this.isSpecial = isSpecial;
    }


    public int getInformation(){
        return information;
    }

    public boolean isSpecial(){
        return isSpecial;
    }

    public int getTitle(){
        return title;
    }

    public String getTime() {
        return time;
    }

    public int getPlace(){
        return place;
    }

    public int getTimestamp(){
        return timestamp;
    }

    public String getMapLocation() {
        switch (place) {
            case R.string.place_plazadetoros:
                // Centrado / Usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kQDT6pb9ieAM";
            case R.string.place_plazamayor:
                // Centrado / Usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.k5Am0_m0Besc";
            case R.string.place_plazasdelaciudad:
                //Centrado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kFYmFL8jrM9Y";
            case R.string.place_bailas:
                // Centrado / Usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.ksH4VDMMrgrk";
            case R.string.place_lasaca:
                // Centrado / Usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kH-5ho1-8k7c";
            case R.string.place_callesdelaciudad:
                // Locales de cuadrilla
            case R.string.place_localesdecuadrilla:
                // Centrado / Usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kdyGebgsSJdY";
            case R.string.place_plazadelolivo:
                // Centrado / Usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kMPJ5p6zVxDU";
            case R.string.place_dehesa:
                // Centrado / Usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kbU0WevON1o0";
            case R.string.place_plazamayor_alameda:
                // Centrado / usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kExnPTRbq_n4";
            case R.string.place_lacompra:
                // Centrado / usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kfRJ9wWRdGxo";
            case R.string.place_valonsadero:
                // Centrado / usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.kTyy3uR_3Z6o";
            case R.string.place_plazaherradores:
                // Centrado / usado
                return "https://www.google.com/maps/d/viewer?mid=zZqWWHMZUiuY.k9zc_9XBr3IE";

        }
        return null;
    }


    //----------------Ubicaciones
    private static ArrayList<LatLng> staticPlacesCoordinates_localescuadrilla = new ArrayList<LatLng>()
    {{

            add(new LatLng(41.7661018,-2.4670661));
            add(new LatLng(41.7659002,-2.4689346));
            add(new LatLng(41.7646982,-2.4609826));
            add(new LatLng(41.7655437,-2.4631552));
            add(new LatLng(41.7607604,-2.4679617));
            add(new LatLng(41.7690041,-2.4667687));
            add(new LatLng(41.7605575,-2.4734295));
            add(new LatLng(41.7667720,-2.4711532));
            add(new LatLng(41.7591074,-2.4705109));
            add(new LatLng(41.7679112,-2.4789208));
            add(new LatLng(41.7666528,-2.4728938));
            add(new LatLng(41.766223,-2.4704876));
        }};

    private static ArrayList<String> staticPlacesNames_localescuadrilla = new ArrayList<String>()
    {{
            add("La Mayor");
            add("El Rosel y San Blas");
            add("Santa Catalina");
            add("La Cruz y San Pedro");
            add("Santiago");
            add("San Miguel");
            add("San Juan");
            add(com.albaitdevs.programasanjuan.albait.AlbaitApplication.getContext().getResources().getString(R.string.word_cuadrilla_santotome));
            add("San Esteban");
            add("El Salvador");
            add(com.albaitdevs.programasanjuan.albait.AlbaitApplication.getContext().getResources().getString(R.string.word_cuadrilla_santabarbara));
            add("La Blanca");
        }};


    public ArrayList<LatLng> getMapMarksLatLong(){

        ArrayList<LatLng> list = new ArrayList<>();

        switch (place) {
            case R.string.place_plazadetoros:
                list.add(new LatLng(41.7661964,-2.4711165)); break;
            case R.string.place_plazamayor:
                list.add(new LatLng(41.7634296,-2.4640006)); break;
            case R.string.place_plazasdelaciudad:
                list.add(new LatLng(41.7643739,-2.4682787));
                list.add(new LatLng(41.7646299,-2.4672219));
                list.add(new LatLng(41.7650161,-2.4691048));
                list.add(new LatLng(41.7634296,-2.4640006));
                break;
            case R.string.place_bailas:
                list.add(new LatLng(41.7641158,-2.4689788));
                list.add(new LatLng(41.7634296,-2.4640006));
                list.add(new LatLng(41.7569711,-2.4543715));
                break;
            case R.string.place_lasaca:
                list.add(new LatLng(41.8154457,-2.5501692));
                list.add(new LatLng(41.7947683,-2.5369406));
                list.add(new LatLng(41.7834411,-2.5190878));
                list.add(new LatLng(41.7661964,-2.4711165));
                break;
            case R.string.place_callesdelaciudad:
            case R.string.place_localesdecuadrilla:
                return staticPlacesCoordinates_localescuadrilla;
            case R.string.place_plazadelolivo:
                list.add(new LatLng(41.7637276,-2.4673413));
                break;
            case R.string.place_dehesa:
                list.add(new LatLng(41.7642538,-2.4709153));
                break;
            case R.string.place_plazamayor_alameda:
                list.add(new LatLng(41.7642538,-2.4709153));
                list.add(new LatLng(41.7634296,-2.4640006));
                break;
            case R.string.place_lacompra:
                //Solo se usa en la Compra
                break;
            case R.string.place_valonsadero:
                //Solo se usa en la Compra
                break;
            case R.string.place_plazaherradores:
                list.add(new LatLng(41.7643739, -2.4682787)); break;
        }

        return list;
    }

    public ArrayList<String> getMapMarksNames(){

        ArrayList<String> list = new ArrayList<>();

        switch (place) {
            case R.string.place_plazadetoros:
                list.add("Plaza de Toros"); break;
            case R.string.place_plazamayor:
                list.add("Plaza Mayor"); break;
            case R.string.place_plazasdelaciudad:
                list.add("Plaza Herradores");
                list.add("Plaza de San Clemente");
                list.add("Plaza del Salvador");
                list.add("Plaza Mayor");
                break;
            case R.string.place_bailas:
                list.add("Plaza de Mariano Granados");
                list.add("Plaza Mayor");
                list.add("San Polo");
                break;
            case R.string.place_lasaca:
                list.add("Pradera de Valonsadero");
                list.add(com.albaitdevs.programasanjuan.albait.AlbaitApplication.getContext().getResources().getString(R.string.word_vega_san_millan));
                list.add("Descansadero");
                list.add("Plaza de Toros");
                break;
            case R.string.place_callesdelaciudad:
            case R.string.place_localesdecuadrilla:
                return staticPlacesNames_localescuadrilla;
            case R.string.place_plazadelolivo:
                list.add("Plaza del Olivo");
                break;
            case R.string.place_dehesa:
                list.add("Alameda de Cervantes");
                break;
            case R.string.place_plazamayor_alameda:
                list.add("Alameda de Cervantes");
                list.add("Plaza Mayor");
                break;
            case R.string.place_lacompra:
                //Solo se usa en la Compra
                break;
            case R.string.place_valonsadero:
                //Solo se usa en la Compra
                break;
            case R.string.place_plazaherradores:
                list.add("Plaza Herradores"); break;
        }

        return list;
    }

    public LatLng getMapCenter() {
        switch (place) {
            case R.string.place_bailas:
                //Plaza Mayor
                return new LatLng(41.7634296,-2.4640006);
            case R.string.place_lasaca:
            case R.string.place_lacompra:
            case R.string.place_valonsadero:
                //Descansadero
                return new LatLng(41.7834411,-2.5190878);
            default:
                //Plaza Herradores
                return new LatLng(41.7643739, -2.4682787);
        }
    }

    public float getMapZoom() {
        switch (place) {
            case R.string.place_bailas:
                return 14f;
            case R.string.place_lasaca:
            case R.string.place_lacompra:
            case R.string.place_valonsadero:
                return 12.0f;
            case R.string.place_callesdelaciudad:
            case R.string.place_localesdecuadrilla:
                return 14.2f;
            default:
                return 15f;
        }
    }
}
