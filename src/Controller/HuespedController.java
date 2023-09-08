package Controller;

import static Conexion.Conexion.close;
import static Conexion.Conexion.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Huesped;

public class HuespedController {
	
	private static final String SELECT = "SELECT * FROM huespedes;";
	private static final String INSERT = "INSERT INTO huespedes(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, idReserva) "
			+ "VALUE(?, ?, ?, ?, ?, ?);";
	private static final String DELETE = "DELETE FROM huespedes WHERE id = ?;";
	private static final String UPDATE = "UPDATE huespedes SET nombre = ?, apellido = ?, fechaDeNacimiento = ?, nacionalidad = ?, "
			+ "telefono = ?, idReserva = ? WHERE id = ?;";

	private static final String SELECT_CON_ID = "SELECT * FROM huespedes where apellido = ?;";

	public List<Huesped> SeleccionarConApellido(String apellido) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Huesped huesped = null;
		Connection conn = null;
		List<Huesped> huespedLista = new ArrayList<>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SELECT_CON_ID);

			pstmt.setString(1, apellido);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				long id = rs.getLong("id");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido");
				Date fechaDeNacimiento = rs.getDate("fechaDeNacimiento");
				String nacionalidad = rs.getString("nacionalidad");
				String telefono = rs.getString("telefono");
				long idReserva = rs.getLong("idReserva");

				huesped = new Huesped(id, nombre, apellido1, fechaDeNacimiento, nacionalidad, telefono, idReserva);

				huespedLista.add(huesped);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				close(rs);
				close(pstmt);
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return huespedLista;
	}

	public List<Huesped> Seleccionar() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Huesped huesped = null;
		List<Huesped> huespedLista = new ArrayList<>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				long id = rs.getLong("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Date fechaDeNacimiento = rs.getDate("fechaDeNacimiento");
				String nacionalidad = rs.getString("nacionalidad");
				String telefono = rs.getString("telefono");
				long idReserva = rs.getLong("idReserva");

				huesped = new Huesped(id, nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, idReserva);

				huespedLista.add(huesped);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				close(rs);
				close(pstmt);
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return huespedLista;
	}

	public int Insertar(Huesped huesped) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertado = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(INSERT);

			pstmt.setString(1, huesped.getNombre());
			pstmt.setString(2, huesped.getApellido());
			pstmt.setDate(3, (java.sql.Date) huesped.getFechaDeNacimiento());
			pstmt.setString(4, huesped.getNacionalidad());
			pstmt.setString(5, huesped.getTelefono());
			pstmt.setLong(6, huesped.getIdReserva());

			insertado = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				close(conn);
				close(pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return insertado;
	}

	public int modificar(Huesped huesped) {
		
        Connection conn = null;
        PreparedStatement pstmt = null;
        int actualizado = 0;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, huesped.getNombre());
            pstmt.setString(2, huesped.getApellido());
            pstmt.setDate(3, (java.sql.Date) huesped.getFechaDeNacimiento());
            pstmt.setString(4, huesped.getNacionalidad());
            pstmt.setString(5, huesped.getTelefono());
            pstmt.setLong(6, huesped.getIdReserva());
            pstmt.setLong(7, huesped.getId());

            actualizado = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {

            try {
                close(conn);
                close(pstmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return actualizado;
		
	}

}
