package com.bit2025.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit2025.emaillist.vo.EmailVo;

@Repository
public class EmailRepository {

	public int deleteById(Long id) {
		int result = 0;

		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from email where id = ?");) {
			pstmt.setLong(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return result;
	}

	public int deleteByEmail(String email) {
		int result = 0;

		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from email where email = ?");) {
			pstmt.setString(1, email);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return result;
	}

	public int insert(EmailVo vo) {
		int result = 0;

		try (Connection con = getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into email(first_name, last_name, email) values (?, ?, ?)");) {
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return result;
	}

	public Long count() {
		Long result = 0L;

		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement("select count(*) from email");
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return result;
	}

	public List<EmailVo> findAll() {
		List<EmailVo> result = new ArrayList<EmailVo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select id, first_name, last_name, email from email order by id desc";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong(1);
				String firstNmae = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);

				EmailVo vo = new EmailVo();
				vo.setId(id);
				vo.setFirstName(firstNmae);
				vo.setLastName(lastName);
				vo.setEmail(email);

				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection con = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.0.183:3306/webdb";
			con = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver Class Not Found");
		}

		return con;
	}
}