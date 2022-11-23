package com.example.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infogram.R;
import com.example.infogram.adapter.CardViewAdapter;
import com.example.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //toolbar
        showToolBar("",false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_profile);

        //layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }
    public void showToolBar(String titulo, boolean botonSubir, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar_profile);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://www.laregion.bo/wp-content/uploads/2019/12/caraaa.jpg", "Carlos Valdivia", "2 dias", "1 me gusta"));
        images.add(new Image("https://www.boliviaentusmanos.com/turismo/imagenes/casa-de-la-moneda-1.jpg", "Luis Perez", "3 dias", "5 me gusta"));
        images.add(new Image("https://lh5.googleusercontent.com/-CINb2hHdBHc/VMfJjASBQDI/AAAAAAAAC0I/23gSET6uSaw/s640/blogger-image-979580039.jpg", "Fernando Torricos", "6 dias", "4 me gusta"));
        images.add(new Image("https://media.tacdn.com/media/attractions-splice-spp-674x446/06/6f/46/35.jpg", "Maria Flores", "5 dias", "6 me gusta"));
        images.add(new Image("https://www.viajesylugares.com/imagenes/copacabana505101_960_720.jpg", "Rolando Morales", "3 dias", "5 me gusta"));
        images.add(new Image("https://www.noticiasfides.com/images/news/2022/09/c-image2022-09-15163039220-417754-A1C5.png", "William Jaimes", "4 dias", "4 me gusta"));
        images.add(new Image("https://www.magazinemanagement.gm-bolivia.com/wp-content/uploads/2021/11/6030819859692969.jpg", "Roberto Paniagua", "2 dias", "3 me gusta"));
        images.add(new Image("https://samaipata.com/wp-content/uploads/2017/03/1a.jpg", "Lorena Herrera", "2 dias", "8 me gusta"));
        images.add(new Image("https://www.boliviaentusmanos.com/turismo/imagenes/cristo-de-la-concordia-1.jpg", "Laura Caceres", "6 dias", "3 me gusta"));
        images.add(new Image("https://www.caxiatours.com/img/packages/normal_d8acf0cbd512140f782bc72f46631cbce14b8cce.jpg", "Marcelo Rojas", "9 dias", "1 me gusta"));

        return images;
    }
}