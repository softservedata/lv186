package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;

/**
 * Created by yarynakharko on 16.08.16.
 */
public class testCustomerUser {
        private static volatile testCustomerUser instance = null;
        private ICustomerUser customerUser = null;

        private testCustomerUser() {
        }

        public static testCustomerUser get() {
            if (instance == null) {
                synchronized (testCustomerUser.class) {
                    if (instance == null) {
                        instance = new testCustomerUser();
                    }
                }
            }
            return instance;
        }
        public ICustomerUser getCustomerUser() {
        return customerUser;
        }

        public void setCustomerUser(ICustomerUser customerUser) {
            this.customerUser = customerUser;
        }

    public void returnToPrevCreateAccount() {
        // Return to the previous state
        // 1.Go to  the admin page
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
        // 2. Log in admin
        // 3. Go to the all customer page
        AllCustomersPage allCustomersPage = applicationAdmin.load()
                .successAdminLogin(AdminUserRepository.get().adminYaryna())
                .gotoAllCustomersPage();

        ICustomerUser testCustomer = testCustomerUser.get().getCustomerUser();
        // 4. Delete currently created user
        if(allCustomersPage.confirmCustomerUserIsCreated(testCustomer) == true ) {
            allCustomersPage = allCustomersPage.deleteCustomerUser(testCustomer);
        }
        // 5. Log out admin
        allCustomersPage.clickSignOut();
    }

}
