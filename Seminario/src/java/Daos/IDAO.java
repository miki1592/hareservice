/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.util.ArrayList;

/**
 *
 * @author romero
 */
public interface IDAO<T>
{
    int Agregar(T entidad);
    void Actualizar(T entidad);
    void Eliminar(T entidad);
    T Get(String atributo);
    T Get(int Atributo);
    ArrayList Listar();
}
