package com.tourism.mgt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tourism.mgt.bean.BookingBean;
import com.tourism.mgt.exception.ApplicationException;
import com.tourism.mgt.exception.DatabaseException;
import com.tourism.mgt.exception.DuplicateRecordException;
import com.tourism.mgt.util.JDBCDataSource;

public class BookingModel {

private static Logger log = Logger.getLogger(BookingModel.class);
	

	public Integer nextPK() throws DatabaseException {
		log.debug("Model nextPK Started");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM T_Booking");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();

		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model nextPK End");
		return pk + 1;
	}

	
	public long add(BookingBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		int pk = 0;

		/*
		 * BookingBean existbean = findByName(bean.getName());
		 * 
		 * if (existbean != null) { throw new
		 * DuplicateRecordException("Booking Name Id already exists"); }
		 */
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO T_Booking VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2,bean.getBookingId());
			pstmt.setString(3,bean.getUserName());
			pstmt.setLong(4,bean.getPkId());
			pstmt.setString(5, bean.getPkName());
			pstmt.setDate(6,new java.sql.Date(bean.getToDate().getTime()));
			pstmt.setDate(7,new java.sql.Date(bean.getFromDate().getTime()));
			pstmt.setDate(8,new java.sql.Date(bean.getbDate().getTime()));
			pstmt.setString(9, bean.getStatus());
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add Booking");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	
	public void delete(BookingBean bean) throws ApplicationException {
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_Booking WHERE ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete Booking");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}

	public BookingBean findByName(String name) throws ApplicationException {
		log.debug("Model findByLogin Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM T_Booking WHERE PK_NAME=?");
		BookingBean bean = null;
		Connection conn = null;
		System.out.println("sql" + sql);
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new BookingBean();
				bean.setId(rs.getLong(1));
				bean.setBookingId(rs.getString(2));
				bean.setUserName(rs.getString(3));
				bean.setPkId(rs.getLong(4));
				bean.setPkName(rs.getString(5));
				bean.setToDate(rs.getDate(6));
				bean.setFromDate(rs.getDate(7));
				bean.setbDate(rs.getDate(8));
				bean.setStatus(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting Booking by login");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByLogin End");
		return bean;
	}

	

	public BookingBean findByPK(long pk) throws ApplicationException {
		log.debug("Model findByPK Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM T_Booking WHERE ID=?");
		BookingBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new BookingBean();
				bean.setId(rs.getLong(1));
				bean.setBookingId(rs.getString(2));
				bean.setUserName(rs.getString(3));
				bean.setPkId(rs.getLong(4));
				bean.setPkName(rs.getString(5));
				bean.setToDate(rs.getDate(6));
				bean.setFromDate(rs.getDate(7));
				bean.setbDate(rs.getDate(8));
				bean.setStatus(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting Booking by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByPK End");
		return bean;
	}

	

	public void update(BookingBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		/*
		 * BookingBean beanExist = findByName(bean.getName()); if (beanExist != null &&
		 * !(beanExist.getId() == bean.getId())) { throw new
		 * DuplicateRecordException("Booking Name is already exist"); }
		 */

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); 
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE T_Booking SET BOOKING_ID=?,USER_NAME=?,PK_ID=?,PK_NAME=?,TO_DATE=?,FROM_DATE=?,B_DATE=?,STATUS=?,"
					+ "CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			pstmt.setString(1,bean.getBookingId());
			pstmt.setString(2,bean.getUserName());
			pstmt.setLong(3,bean.getPkId());
			pstmt.setString(4, bean.getPkName());
			pstmt.setDate(5,new java.sql.Date(bean.getToDate().getTime()));
			pstmt.setDate(6,new java.sql.Date(bean.getFromDate().getTime()));
			pstmt.setDate(7,new java.sql.Date(bean.getbDate().getTime()));
			pstmt.setString(8, bean.getStatus());
			pstmt.setString(9, bean.getCreatedBy());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.setLong(13, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating Booking ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
	}

	

	public List search(BookingBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	

	public List search(BookingBean bean, int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model search Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM T_Booking WHERE 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getUserName() != null && bean.getUserName().length() > 0) {
				sql.append(" AND USER_NAME like '" + bean.getUserName() + "%'");
			}
			if (bean.getBookingId() != null && bean.getBookingId().length() > 0) {
				sql.append(" AND BOOKING_ID like '" + bean.getBookingId() + "%'");
			}
			if (bean.getPkName() != null && bean.getPkName().length() > 0) {
				sql.append(" AND PK_NAME like '" + bean.getPkName() + "%'");
			}
			
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" Limit " + pageNo + ", " + pageSize);
		}
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new BookingBean();
				bean.setId(rs.getLong(1));
				bean.setBookingId(rs.getString(2));
				bean.setUserName(rs.getString(3));
				bean.setPkId(rs.getLong(4));
				bean.setPkName(rs.getString(5));
				bean.setToDate(rs.getDate(6));
				bean.setFromDate(rs.getDate(7));
				bean.setbDate(rs.getDate(8));
				bean.setStatus(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in search Booking");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model search End");
		return list;
	}

	

	public List list() throws ApplicationException {
		return list(0, 0);
	}


	public List list(int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model list Started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from T_Booking");

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		
		System.out.println("sql in list Booking :"+sql);
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingBean bean = new BookingBean();
				bean.setId(rs.getLong(1));
				bean.setBookingId(rs.getString(2));
				bean.setUserName(rs.getString(3));
				bean.setPkId(rs.getLong(4));
				bean.setPkName(rs.getString(5));
				bean.setToDate(rs.getDate(6));
				bean.setFromDate(rs.getDate(7));
				bean.setbDate(rs.getDate(8));
				bean.setStatus(rs.getString(9));
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedDatetime(rs.getTimestamp(13));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting list of Bookings");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model list End");
		return list;
	}
}
