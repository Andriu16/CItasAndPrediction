/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author andri
 */
public class UsuarioRol {
    private int idUsuario;     
    private String tipoUsuario; 
    private cargo cargo;

    public UsuarioRol() {
    }

    public UsuarioRol(int idUsuario, String tipoUsuario, cargo cargo) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cargo = cargo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public cargo getCargo() {
        return cargo;
    }

    public void setCargo(cargo cargo) {
        this.cargo = cargo;
    }
    
    
    
    
}
