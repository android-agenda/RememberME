package com.example.sottox19.remembermeapp.Logica;

import android.util.Log;

import com.example.sottox19.remembermeapp.Conexion.BaseDeDatos;
import com.example.sottox19.remembermeapp.Coordinador.CoordinadorTask;
import com.example.sottox19.remembermeapp.ModeloVO.TaskVO;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class LogicaTask {
    private CoordinadorTask mCoordTask;
    private TaskVO mTask;
    private ArrayList<TaskVO> listaTask;
public void setCoordinador(CoordinadorTask coordTask){
    this.mCoordTask = coordTask;
}

public void validarAddTask(TaskVO task) {
    boolean isSaved = BaseDeDatos.mTaskDAO.addTask(task);
    if (isSaved == true) {
        Log.d("Database", "Registro de la tabla Task Anadido");
    }
}

public void validarDeleteTask(int id){
        int isDeleted = BaseDeDatos.mTaskDAO.deleteTask(id);
    if(isDeleted !=0){
        Log.d("Database","Se eliminaron " + isDeleted + " registros de la tabla task");
    }else{
        Log.d("Database","No se encontraron registros en la tabla Task");
    }
}
public TaskVO validarBuscarTask(int id){
    mTask = BaseDeDatos.mTaskDAO.fetchById(id);
    if(mTask!= null){
        Log.d("Database","Se encontro el registro "+ id+ " en la tabla Task");
        return mTask;
    } else {
        Log.d("Database","No se encontro el registro " + id + " en la tabla Task");
        return null;
    }
}
public ArrayList<TaskVO> validarListaTask() {
    listaTask = BaseDeDatos.mTaskDAO.fetchAllTask();
    if (listaTask != null) {
        Log.d("Database", "Lista Task creada");
        return listaTask;
    } else {
        Log.d("Database", "No hay registros en la tabla Task");
        return null;
    }
}
}



