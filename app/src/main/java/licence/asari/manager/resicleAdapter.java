package licence.asari.manager;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class resicleAdapter extends RecyclerView.Adapter<resicleAdapter.MyViewHolder> {


    private ArrayList<User> userList;

    public resicleAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        private TextView nom,Pnombre,PJugados, Pvictoria,Pderrota, Pjugar,pContra,Pdiferencia,pExtras;

        public MyViewHolder(final View view) {
            super(view);

            nom = view.findViewById(R.id.placaNom);
            Pnombre = view.findViewById(R.id.placaPunto);
            PJugados= view.findViewById(R.id.PJugados);
            Pvictoria =  view.findViewById(R.id.Vict);
            Pderrota =  view.findViewById(R.id.Pderrota);
            Pjugar =  view.findViewById(R.id.Pjugados);
            pContra = view.findViewById(R.id.Pcontra);
            Pdiferencia = view.findViewById(R.id.Pdiferencia);
            pExtras = view.findViewById(R.id.Pextras);

}
}

    @NonNull
    @Override
    public resicleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.placa,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull resicleAdapter.MyViewHolder holder, int position) {

        String name = userList.get(position).getNick();
        String Pnom = userList.get(position).getPuntos();
        String PJugados = userList.get(position).getJugados();
        String Pvict = userList.get(position).getVictoria();
        String Pderr = userList.get(position).getDerrota();
        String Pjuga = userList.get(position).getpJugados();
        String Pcontr = userList.get(position).getpContra();
        String Pdifere = userList.get(position).getpDiferencia();
        String Petras = userList.get(position).getpExtras();

        holder.nom.setText(name);
        holder.Pnombre.setText(Pnom);
        holder.PJugados.setText(PJugados);
        holder.Pvictoria.setText(Pvict);
        holder.Pderrota.setText(Pderr);
        holder.Pjugar.setText(Pjuga);
        holder.pContra.setText(Pcontr);
        holder.Pdiferencia.setText(Pdifere);
        holder.pExtras.setText(Petras);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

