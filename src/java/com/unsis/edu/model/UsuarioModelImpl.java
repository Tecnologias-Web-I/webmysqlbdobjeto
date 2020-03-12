
package com.unsis.edu.model;
import com.unsis.edu.entity.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UsuarioModelImpl implements IUsuarioModel{
    private SessionFactory sf = null;
    private Session s = null;

    @Override
    public void crearUsuario(Usuario usuario) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            s = sf.openSession();
            s.beginTransaction();
            s.save(usuario); // insert into usuario() values();
            s.getTransaction().commit();
            s.close();
            sf.close();
        } catch (HibernateException e) {
            System.out.println("Erro al crear el registro: " + e.getMessage());
        } 
    }
    
    public static void main(String[] args) {
        IUsuarioModel iusuario = new UsuarioModelImpl();
        Usuario usuario = new Usuario("Juan", "juan@gmail.com");
        
        iusuario.crearUsuario(usuario);
    }
}
