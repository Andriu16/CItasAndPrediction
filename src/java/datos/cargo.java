/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.List;

/**
 *
 * @author andri
 */
public class cargo {
    private int codigo;
    private String NombreCargo;
    private boolean estado;
    private List<Permiso> permisos;

    public cargo() {
    }

    public cargo(int codigo, String NombreCargo, boolean estado, List<Permiso> permisos) {
        this.codigo = codigo;
        this.NombreCargo = NombreCargo;
        this.estado = estado;
        this.permisos = permisos;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCargo() {
        return NombreCargo;
    }

    public void setNombreCargo(String NombreCargo) {
        this.NombreCargo = NombreCargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
    
}
