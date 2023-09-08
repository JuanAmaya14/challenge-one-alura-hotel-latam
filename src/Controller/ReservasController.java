package Controller;

import static Conexion.Conexion.close;
import static Conexion.Conexion.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Reserva;

// RESERVAS CONTROLLER
public class ReservasController {

	private static final String SELECT = "SELECT * FROM reservas;";
	private static final String INSERT = "INSERT INTO reservas(fechaEntrada, fechaSalida, valor, formaPago) VALUE(?, ?, ?, ?);";
	private static final String DELETE = "DELETE FROM reservas WHERE id = ?;";
	private static final String UPDATE = "UPDATE reservas SET fechaEntrada = ?, fechaSalida = ?, valor = ?, formaPago = ? WHERE id = ?;";

	private static final String SELECT_MANDAR_ID = "SELECT id FROM reservas where fechaEntrada = ? and fechaSalida = ? and valor = ? and formaPago = ?";

	private static final String SELECT_CON_ID = "SELECT * FROM reservas where id = ?;";

	// GET
	public List<Reserva> Seleccionar() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reserva reserva = null;
		List<Reserva> reservaLista = new ArrayList<>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				long id = rs.getLong("id");
				Date fechaEntrada = rs.getDate("fechaEntrada");
				Date fechaSalida = rs.getDate("fechaSalida");
				double valor = rs.getDouble("valor");
				String formaPago = rs.getString("formaPago");

				reserva = new Reserva(id, fechaEntrada, fechaSalida, valor, formaPago);

				reservaLista.add(reserva);
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

		return reservaLista;
	}

	// GET MANDANDO ID
	public List<Reserva> SeleccionarConId(long id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reserva reserva = null;
		List<Reserva> reservaLista = new ArrayList<>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SELECT_CON_ID);

			pstmt.setLong(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				long id1 = rs.getLong("id");
				Date fechaEntrada = rs.getDate("fechaEntrada");
				Date fechaSalida = rs.getDate("fechaSalida");
				double valor = rs.getDouble("valor");
				String formaPago = rs.getString("formaPago");

				reserva = new Reserva(id1, fechaEntrada, fechaSalida, valor, formaPago);

				reservaLista.add(reserva);

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

		return reservaLista;
	}

	// GET RETORNANDO ID
	public long SeleccionarId(Reserva reserva) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long id = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SELECT_MANDAR_ID);

			pstmt.setDate(1, (java.sql.Date) reserva.getFechaEntrada());
			pstmt.setDate(2, (java.sql.Date) reserva.getFechaSalida());
			pstmt.setDouble(3, reserva.getValor());
			pstmt.setString(4, reserva.getFormaPago());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				id = rs.getLong("id");

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

		return id;
	}

	// POST
	public int Insertar(Reserva reserva) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertado = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(INSERT);

			pstmt.setDate(1, (java.sql.Date) reserva.getFechaEntrada());
			pstmt.setDate(2, (java.sql.Date) reserva.getFechaSalida());
			pstmt.setDouble(3, reserva.getValor());
			pstmt.setString(4, reserva.getFormaPago());

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

	// PUT
	public int modificar(Reserva reserva) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int actualizado = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE);

			pstmt.setDate(1, (java.sql.Date) reserva.getFechaEntrada());
			pstmt.setDate(2, (java.sql.Date) reserva.getFechaSalida());
			pstmt.setDouble(3, reserva.getValor());
			pstmt.setString(4, reserva.getFormaPago());
			pstmt.setLong(5, reserva.getId());

			actualizado = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {

			try {
				close(conn);
				close(pstmt);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}

		}

		return actualizado;

	}

	// DELETE
	public int Eliminar(Reserva reserva) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int eliminado = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE);

			pstmt.setLong(1, reserva.getId());

			eliminado = pstmt.executeUpdate();

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

		return eliminado;
	}

}
