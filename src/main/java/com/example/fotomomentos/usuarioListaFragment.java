package com.example.fotomomentos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fotomomentos.dummy.DummyContent;
import com.example.fotomomentos.dummy.DummyContent.DummyItem;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class usuarioListaFragment extends Fragment implements View.OnClickListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    ArrayList<UsuarioV> listaUsuarios;
    RecyclerView recyclerUsuarios;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    Activity activity;
    ComunicaFragment interfaceComunicaFragment;



    public usuarioListaFragment() {
    }




    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static usuarioListaFragment newInstance(int columnCount) {
        usuarioListaFragment fragment = new usuarioListaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View vista = inflater.inflate(R.layout.fragment_usuarios_list, container, false);

        // Set the adapter
        if (vista instanceof RecyclerView) {
            Context context = vista.getContext();
            RecyclerView recyclerView = (RecyclerView) vista;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyusuariosRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }

        listaUsuarios = new ArrayList<>();
        recyclerUsuarios = vista.findViewById(R.id.listrecycler);
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaUsuarios();
        adaptador adapter = new adaptador(listaUsuarios);
        recyclerUsuarios.setAdapter(adapter);

        adapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"selecciona: "
                        +listaUsuarios.get(recyclerUsuarios
                        .getChildAdapterPosition(v)).getNombre(),Toast.LENGTH_SHORT).show();

                interfaceComunicaFragment.enviarPersonje(listaUsuarios.get(recyclerUsuarios.getChildAdapterPosition(v)));
            }


        });

        return vista;
    }

    private void llenarListaUsuarios() {
        listaUsuarios.add(new UsuarioV("usuario1","es el momento 1",R.drawable.momento1,getString(R.string.descripcioncompleta1 ),"1"));
        listaUsuarios.add(new UsuarioV("usuario2","es el momento 2",R.drawable.momento2,"comentario completo","2"));
        listaUsuarios.add(new UsuarioV("usuario3","es el momento 3",R.drawable.momento3,"comentario completo","3"));
        listaUsuarios.add(new UsuarioV("usuario3","es el momento 4",R.drawable.momento4,"comentario completo","4"));

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragment = (ComunicaFragment) this.activity;
        }



        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
