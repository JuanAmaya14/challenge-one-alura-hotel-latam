package Controller;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Models.Huesped;
import Models.Reserva;

import static Conexion.Conexion.getConnection;
import static Conexion.Conexion.close;

public class HuespedController {

	private static final String SELECT = "SELECT * FROM huespedes;";
	private static final String INSERT = "INSERT INTO huespedes(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, idReserva) "
			+ "VALUE(?, ?, ?, ?, ?, ?);";
	private static final String DELETE = "DELETE FROM huespedes WHERE id = ?;";
	private static final String UPDATE = "UPDATE huespedes SET nombre = ?, apellido = ?, fechaDeNacimiento = ?, nacionalidad = ?, "
			+ "telefono = ?, idReserva = ?;";

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
				;
				String telefono = rs.getString("telefono");
				long idReserva = rs.getLong("idReserva");

				huesped = new Huesped(id, nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, idReserva);

				huespedLista.add(huesped);

//	                System.out.println(huesped);

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

}
