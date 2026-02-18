package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CollegeStudent;
import com.app.repository.CollegeStudRepo;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CollegeService {

	@Autowired
	private CollegeStudRepo csr;

	public CollegeService(CollegeStudRepo csr) {
		this.csr = csr;
	}

	@Autowired
	private MailSenderService mss;

	public CollegeService(MailSenderService mss) {
		this.mss = mss;
	}

	public boolean saveStudent(CollegeStudent cs) throws Exception {
		
		String subject ="System Genrated Message";
		String body = "<html>"
		        + "<body style='font-family: \"Segoe UI\", Arial, sans-serif; background: linear-gradient(135deg, #e0eafc, #cfdef3); padding: 28px;'>"
		        + "<div style='max-width: 600px; margin: auto; background: white; padding: 28px 28px 20px 28px; border-radius: 16px; box-shadow: 0 6px 32px rgba(52, 92, 220, 0.07);'>"
		        + "<h2 style='color: #3498db; letter-spacing: 1px; text-align: center; margin-top:0;'>Hello,</h2>"

		        + "<p style='font-size: 17px; color: #232323; text-align: center;'>"
		        + "Your record has been <b style='color:#27ae60;'>added successfully</b>."
		        + "</p>"

		        + "<div style='margin: 22px 0; border-radius: 12px; background: #f8fafc; padding: 18px 16px;'>"
		        + "<p style='font-size: 16px; color: #555; text-align:center;'>"
		        + "Thank you. Your information has been saved in our system. You can now continue using the application."
		        + "</p>"
		        + "</div>"

		        + "<hr style='border: none; border-top: 2px solid #f0f0f0; margin: 24px 0;'>"

		        + "<p style='text-align: center;'>"
		        + "<a href='#'"
		        + " style='background: linear-gradient(90deg, #2ecc71 30%, #27ae60 100%);"
		        + " color: white;"
		        + " text-decoration: none;"
		        + " padding: 12px 36px;"
		        + " border-radius: 100px;"
		        + " font-size: 17px;"
		        + " font-weight: bold;"
		        + " box-shadow: 0 3px 10px rgba(39,174,96,0.14);"
		        + " display: inline-block;'>"
		        + "Record Added"
		        + "</a>"
		        + "</p>"

		        + "<p style='margin-top: 38px; text-align: right; font-size: 15px;'>"
		        + "Best Regards,<br>"
		        + "<b>College Administration</b>"
		        + "</p>"

		        + "<p style='font-size: 13px; color: #7b7b7b; text-align:center; margin-bottom:0;'>"
		        + "<em>This is an automated confirmation email.</em>"
		        + "</p>"

		        + "</div>"
		        + "</body>"
		        + "</html>";



		System.out.println(cs.getStudentEmailAdress());
		
		
		mss.sendEmailMime(body, subject, cs.getStudentEmailAdress());
		return csr.save(cs).getStudentId() != null;
	}

	public List<CollegeStudent> getAllStuds() {

		return csr.findAll();
	}

	public void deleteById(Integer id) {
		csr.deleteById(id);
	}
}
