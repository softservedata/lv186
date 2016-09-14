package ss.af.reporting.tests;

import java.util.Random;

import ss.af.reporting.annotations.ServiceReport;

public class BusinessLogicMock {

    public static void main(String[] args) {
        BusinessLogicMock mock = new BusinessLogicMock();
        mock.doLogic();
    }

    @ServiceReport
    public BusinessLogicMock() {
        //NothIngG
    }

    public void doLogic() {
        Random rndm = new Random();
        doLogic(rndm.nextInt(451) + 50); //adding +50 in case of hitting 0
    }

    @ServiceReport
    public void doLogic(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
