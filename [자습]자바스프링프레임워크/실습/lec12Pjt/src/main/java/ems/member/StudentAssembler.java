package ems.member;

import ems.member.dao.StudentDao;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentAssembler {

    private StudentDao studentDao;
    private StudentRegisterService registerService;
    private StudentModifyService modifyService;
    private StudentDeleteService deleteService;
    private StudentSelectService selectService;
    private StudentAllSelectService allSelectService;

    public StudentAssembler() {
        studentDao = new StudentDao();
        registerService = new RegisterService(studentDao);
        modifyService = new ModifyService(studentDao);
        deleteService = new DeleteService(studentDao);
        selectService = new SelectService(studentDao);
        allSelectService = new AllSelectService(studentDao);
    }
}
