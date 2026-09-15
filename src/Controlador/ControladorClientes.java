/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import Modelo.Clientes;

/**
 *
 * @author Usuario
 */
public class ControladorClientes {

    private ArrayList<Clientes> listaClientes;

    public ControladorClientes(ArrayList<Clientes> listaClientes) {
        this.listaClientes = new ArrayList<>();
    }

    public boolean registrarCliente(Clientes clienteNuevo) {
        Clientes buscar = buscarCliente(clienteNuevo.getDocumentoIdentidad());
        if (buscar != null) {
            return false;
        }
        listaClientes.add(clienteNuevo);
        return true;
    }

    public Clientes buscarCliente(int documentoBuscar) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getDocumentoIdentidad() == documentoBuscar) {
                return listaClientes.get(i);
            }
        }
        return null;
    }

    public boolean editarCliente(Clientes clienteEditado) {
        Clientes buscar = buscarCliente(clienteEditado.getDocumentoIdentidad());
        if (buscar != null) {
            buscar.setNombreCompleto(clienteEditado.getNombreCompleto());
            buscar.setDireccion(clienteEditado.getDireccion());
            buscar.setTelefono(clienteEditado.getTelefono());
            return true;
        }
        return false;
    }

    public boolean eliminarCliente(int documento) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getDocumentoIdentidad() == documento) {
                if (listaClientes.get(i).isLibroPrestado() == true) {
                    return false;
                }
                listaClientes.remove(i);
                return true;
            }
        }
        return false;
    }
}
