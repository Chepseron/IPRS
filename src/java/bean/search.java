/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;


import db.AgencyCategories;
import javax.faces.bean.SessionScoped;
import db.AgencyPerms;
//import iconnect.db.ConnectAgencies;
import db.Docums;
import db.DoiDate;
import db.Doubles;
import db.Hits;
import db.Human;
import db.IconnectUsers;
import db.IprsAudit;
import db.IprsImg;
import db.QueryLog;
import db.Users;
import db.SearchCount;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.richfaces.component.html.HtmlDataTable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ogutu
 */
@ManagedBean(name = "search")
@SessionScoped
public class search {

    @PersistenceContext(name = "immigrationPU")
    private EntityManager em;
    @Resource
    UserTransaction utx;
    private AgencyPerms agencyperms = new AgencyPerms();
    //private ConnectAgencies connectagencies = new ConnectAgencies();
    private IconnectUsers connectusers = new IconnectUsers();
    private IconnectUsers connectusers1 = new IconnectUsers();
    private Human human = new Human();//instance of entity class human.
    private IprsImg img = new IprsImg();
    private Doubles doubles = new Doubles();
    private Hits hits = new Hits();
    private Users rangeusers = new Users();
    private Docums docs = new Docums();
    private QueryLog log = new QueryLog();
    private DoiDate passport = new DoiDate();
    private DoiDate passport2 = new DoiDate();
    private IprsAudit aduit = new IprsAudit();
    private String id = new String();
    private String pass = new String();
    private String users = new String();
    private String username = new String();
    private String serial = new String();
    private String birthYear = new String();
    private String passportnumber = new String();
    private List<DoiDate> passportlist;
    private List<AgencyPerms> agencypermlist = new ArrayList<AgencyPerms>();// a list to contain the content from the entity class agencyperms
    private List<IconnectUsers> iconnectuserlist = new ArrayList<IconnectUsers>();
    private List<IconnectUsers> agencyuserlist = new ArrayList<IconnectUsers>();
    private List<IconnectUsers> agencyuserlist2 = new ArrayList<IconnectUsers>();
    private List<IprsAudit> auditlist = new ArrayList<IprsAudit>();
    private List<QueryLog> userloglist = new ArrayList<QueryLog>();
    private List<Human> humanlist = new ArrayList<Human>();
    private List<Doubles> doublist;
    private List<Human> humanlist2;
    private List<Docums> docslist;
    private List<Hits> hitlist = new ArrayList<Hits>();
    private List<SelectItem> acat = new ArrayList<SelectItem>();
    private List<Users> userrangelist = new ArrayList<Users>();
    private List<QueryLog> loglist = new ArrayList<QueryLog>();
    private List<String> selectedItems;
    private HtmlDataTable agencytable = new HtmlDataTable();// a html
    private HtmlDataTable humantable = new HtmlDataTable();// a html
    private HtmlDataTable passportable = new HtmlDataTable();
    private HtmlDataTable doubletable = new HtmlDataTable();
    private HtmlDataTable deactivate = new HtmlDataTable();
    public String searchString = new String();
    private String passportnum = new String();
    private String searchString2 = new String();
    private String searchpassport = new String();
    private String agencyid = new String();
    private String pid = new String();
    private String newpass = new String();
    private String error = new String();
    private String newusername = new String();
    private String agencyname = new String();
    private String confirmpass = new String();
    private String sub_user = "sub_user";

    //Search Counter
    private List<SearchCount> searchlist = new ArrayList<SearchCount>();// a list to contain the content from the entity class search_count
    private HtmlDataTable searchtable = new HtmlDataTable();// a html


    /** Creates a new instance of search */
    public search() {
    }

    /**login to the system*/
    public String login() {

        try {
            connectusers = (IconnectUsers) em.createQuery("SELECT i FROM IconnectUsers i WHERE i.password ='" + pass + "'and i.userid ='" + username + "'").getSingleResult();
            Calendar excal1 = Calendar.getInstance();
            Calendar excal2 = Calendar.getInstance();
            excal2.setTime(connectusers.getExpiryDate());
            excal1.setTimeInMillis(System.currentTimeMillis());
            if (excal1.after(excal2)) {
                return "/changepassword.jsp?faces-redirect=true";

            }
            if (getPass().length() < 0) {
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error:enter password and username"));
            }
            if (connectusers.getRoleuser().equalsIgnoreCase("admin") && !logged()) {
                utx.begin();
                aduit.setAgencyId("IPRS");
                aduit.setAction("logged into system");
                aduit.setUserId(connectusers.getUserid());
                aduit.setTimestamp(new java.util.Date());
                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                aduit.setTid(new BigDecimal(ttid));
                connectusers.setLogged("1");
                em.merge(connectusers);
                em.persist(aduit);
                utx.commit();
                return "/index.jsp?faces-redirect=true";
            } else if (connectusers.getStatus().equalsIgnoreCase("inactive")) {
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("access denied contact administrator"));
            } else if (connectusers.getPassword().equalsIgnoreCase("oooo")) {
                return "/changepassword3.jsp?faces-redirect=true";
            } else if (!logged()) {
                agencyperms = (AgencyPerms) em.createQuery("SELECT a FROM AgencyPerms a WHERE a.agencyId = '" + connectusers.getAgencyId() + "'").getSingleResult();
                setAgencyperms(agencyperms);
                utx.begin();
                aduit.setAgencyId("IPRS");
                aduit.setAction("logged into system");
                aduit.setUserId(connectusers.getUserid());
                aduit.setTimestamp(new java.util.Date());
                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                aduit.setTid(new BigDecimal(ttid));
                connectusers.setLogged("1");
                em.merge(connectusers);
                em.persist(aduit);
                utx.commit();
                return "/search.jsp?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("already logged in please logout"));
                return "/welcomeJSF2.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: wrong password"));
        }
        return "/welcomeJSF.jsp";
    }

    /**logout of the system*/
    public String logout() {

        try {
            utx.begin();
            aduit.setAgencyId("IPRS");
            aduit.setAction("logged out of the system");
            aduit.setUserId(connectusers.getUserid());
            aduit.setTimestamp(new java.util.Date());
            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
            aduit.setTid(new BigDecimal(ttid));
            connectusers.setLogged("0");
            em.merge(connectusers);
            em.persist(aduit);
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        connectusers = new IconnectUsers();
        setImg(new IprsImg());
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "/welcomeJSF.jsp";
    }

    /**method to change the password once the user forgets*/
    public String change_password() {
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        c1.add(Calendar.DATE, 30);
        try {
            connectusers = (IconnectUsers) em.createQuery("SELECT i FROM IconnectUsers i WHERE i.password ='" + pass + "'and i.userid ='" + username + "'").getSingleResult();
            agencyperms = (AgencyPerms) em.createQuery("SELECT a FROM AgencyPerms a WHERE a.agencyId =" + connectusers.getAgencyId()).getSingleResult();
            Pattern p1 = Pattern.compile("^\\w*(?=\\w*\\d)(?=\\w*[a-z])(?=\\w*[A-Z])\\w*$");
            Matcher m1 = p1.matcher(getNewpass());
            boolean matchFound1 = m1.matches();
            if (connectusers.getPassword().equalsIgnoreCase(pass)) {
                if (newpass.equalsIgnoreCase(confirmpass)) {

                    if (getNewpass().length() < 6 || getNewpass().length() > 20) {
                        FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: Your password is less than 6 characters or greator than 20 chars."));
                    } else if (!matchFound1) {

                        FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: Your password is NOT strong enough."));
                    } else {

                        utx.begin();
                        connectusers.setCreateDate(new java.util.Date());
                        connectusers.setExpiryDate(c1.getTime());
                        connectusers.setAgencyId(agencyperms.getAgencyId().toString());
                        connectusers.setPassword(newpass);
                        aduit.setAgencyId("IPRS");
                        aduit.setAction("changed password");
                        aduit.setUserId(connectusers.getUserid());
                        aduit.setTimestamp(new java.util.Date());
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        aduit.setTid(new BigDecimal(ttid));
                        em.persist(aduit);
                        em.merge(connectusers);
                        utx.commit();
                        return "/welcomeJSF.jsp";
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: passwords dont match."));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: passwords dont match."));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error:thats not your password"));

        }
        return "changepassword.jsp";
    }

    /**resets an individuals password to oooo*/
    public void resetpass() {
        connectusers = (IconnectUsers) deactivate.getRowData();
        try {

            utx.begin();
            connectusers.setPassword("oooo");
            aduit.setAgencyId("IPRS");
            aduit.setAction("reset password");
            aduit.setUserId(connectusers.getUserid());
            aduit.setTimestamp(new java.util.Date());
            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
            aduit.setTid(new BigDecimal(ttid));
            em.persist(aduit);
            em.merge(connectusers);
            utx.commit();
        } catch (Exception e) {
        }
        connectusers = (IconnectUsers) em.createQuery("SELECT i FROM IconnectUsers i WHERE i.password ='" + pass + "'and i.userid ='" + username + "'").getSingleResult();
    }

    public void rangeusers() {

        try {
            utx.begin();
            aduit.setAgencyId("IPRS");
            aduit.setAction("added user range");
            aduit.setUserId(connectusers.getUserid());
            aduit.setTimestamp(new java.util.Date());
            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
            aduit.setTid(new BigDecimal(ttid));
            rangeusers.setMaximum(rangeusers.getMaximum());
            rangeusers.setMinimum(rangeusers.getMinimum());
            rangeusers.setValue(rangeusers.getValue());
            rangeusers.setUserId(new BigDecimal(ttid));
            em.persist(rangeusers);
            em.persist(aduit);
            utx.commit();

            FacesContext.getCurrentInstance().addMessage("abmt_reg_form120", new FacesMessage("SAVED SUCCESSFULLY"));
        } catch (Exception e) {
        }
    }

    public void rangehits() {
        try {
            utx.begin();
            aduit.setAgencyId("IPRS");
            aduit.setAction("added hits range");
            aduit.setUserId(connectusers.getUserid());
            aduit.setTimestamp(new java.util.Date());
            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
            aduit.setTid(new BigDecimal(ttid));
            hits.setHit("none");
            hits.setMaximum(hits.getMaximum());
            hits.setMinimum(hits.getMinimum());
            hits.setValue(hits.getValue());
            hits.setId(new BigDecimal(ttid));
            em.persist(hits);
            em.persist(aduit);
            utx.commit();
            FacesContext.getCurrentInstance().addMessage("abmt_reg_form120", new FacesMessage("SAVED SUCCESSFULLY"));
        } catch (Exception e) {
        }

    }

    public boolean isLoggedIn() {
        if (connectusers.getPassword() != null) {
            return true;
        }
        return false;
    }

    public boolean isADMIN() {
        if (connectusers.getRoleuser().equalsIgnoreCase("user")) {
            return true;
        }
        return false;
    }

    public boolean isCHECKER() {
        if (connectusers.getRoleuser().equalsIgnoreCase("checker")) {
            return true;
        }
        return false;
    }

    public void clear() {
        agencyperms = new AgencyPerms();
    }

    public boolean logged() {
        if (Integer.parseInt(connectusers.getLogged()) == 1) {
            return true;
        }
        return false;
    }

    public boolean isLOGGED() {
        if (Integer.parseInt(connectusers.getLogged()) == 1) {
            return true;
        }
        return false;
    }

    /**method to change the password of the system*/
    public String change_password2() {
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        c1.add(Calendar.DATE, 30);
        try {
            connectusers = (IconnectUsers) em.createQuery("SELECT i FROM IconnectUsers i WHERE i.password ='" + pass + "'and i.userid ='" + username + "'").getSingleResult();
            Pattern p1 = Pattern.compile("^\\w*(?=\\w*\\d)(?=\\w*[a-z])(?=\\w*[A-Z])\\w*$");
            Matcher m1 = p1.matcher(getNewpass());
            boolean matchFound1 = m1.matches();
            if (connectusers.getPassword().equalsIgnoreCase(pass)) {
                if (newpass.equalsIgnoreCase(confirmpass)) {

                    if (getNewpass().length() < 6 || getNewpass().length() > 20) {

                        FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: Your password is less than 6 characters or greator than 20 chars."));
                    } else if (!matchFound1) {

                        FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: Your password is NOT strong enough."));
                    } else {

                        utx.begin();
                        connectusers.setCreateDate(new java.util.Date());
                        connectusers.setExpiryDate(c1.getTime());
                        connectusers.setPassword(newpass);
                        aduit.setAgencyId("IPRS");
                        aduit.setAction("changed password");
                        aduit.setUserId(connectusers.getUserid());
                        aduit.setTimestamp(new java.util.Date());
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        aduit.setTid(new BigDecimal(ttid));
                        em.persist(aduit);
                        em.merge(connectusers);
                        utx.commit();
                        return "/welcomeJSF.jsp";
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: passwords dont match."));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: passwords dont match."));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error:thats not your password"));
        }
        return "changepassword2.jsp";
    }

    /**after reseting the password the user is given an option to change the password using the method below*/
    public String change_password3() {
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        c1.add(Calendar.DATE, 30);
        try {
            connectusers = (IconnectUsers) em.createQuery("SELECT i FROM IconnectUsers i WHERE  i.userid ='" + username + "'").getSingleResult();
            Pattern p1 = Pattern.compile("^\\w*(?=\\w*\\d)(?=\\w*[a-z])(?=\\w*[A-Z])\\w*$");
            Matcher m1 = p1.matcher(getNewpass());
            boolean matchFound1 = m1.matches();

            if (newpass.equalsIgnoreCase(confirmpass)) {

                if (getNewpass().length() < 6 || getNewpass().length() > 20) {

                    FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: Your password is less than 6 characters or greator than 20 chars."));
                } else if (!matchFound1) {

                    FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error: Your password is NOT strong enough."));
                } else {

                    utx.begin();
                    connectusers.setCreateDate(new java.util.Date());
                    connectusers.setExpiryDate(c1.getTime());
                    connectusers.setPassword(newpass);
                    aduit.setAgencyId("IPRS");
                    aduit.setAction("changed password");
                    aduit.setUserId(connectusers.getUserid());
                    aduit.setTimestamp(new java.util.Date());
                    int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                    aduit.setTid(new BigDecimal(ttid));
                    em.persist(aduit);
                    em.merge(connectusers);
                    utx.commit();
                    return "/welcomeJSF.jsp";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error:passwords dont match."));
            }


        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("abmt_reg_form09", new FacesMessage("Error:thats not your password"));

        }
        return "changepassword3.jsp";
    }

    /**method to register an agency*/
    public String saveagent() {
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        c1.add(Calendar.DATE, 30);
        try {

            if (agencyperms.getTrial().equalsIgnoreCase("yes")) {
                utx.begin();
                aduit.setAgencyId("IPRS");
                aduit.setAction("registered agency");
                aduit.setUserId(connectusers.getUserid());
                agencyperms.setInitialpay(BigInteger.ZERO);
                agencyperms.setAmountQueried(BigInteger.ZERO);
                aduit.setTimestamp(new java.util.Date());
                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                int agencyid2 = (int) System.currentTimeMillis()%100000 + agencyperms.getName().hashCode()%100;
                aduit.setTid(new BigDecimal(ttid));
                agencyperms.setAgencyId(new BigDecimal(agencyid2));
                agencyperms.setHit(1);
                agencyperms.setUsers(1);
                agencyperms.setExpiryDate(c1.getTime());
                agencyperms.setCreateDate(new java.util.Date());
                em.persist(aduit);
                em.persist(agencyperms);
                utx.commit();

            } else {
                utx.begin();
                aduit.setAgencyId("IPRS");
                aduit.setAction("registered agency");
                aduit.setUserId(connectusers.getUserid());
                aduit.setTimestamp(new java.util.Date());
                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                int agencyid2 = (int) System.currentTimeMillis()%100000 + agencyperms.getName().hashCode()%100;
                aduit.setTid(new BigDecimal(ttid));
                agencyperms.setAgencyId(new BigDecimal(agencyid2));
                agencyperms.setHit(1);
                agencyperms.setUsers(1);
                agencyperms.setCreateDate(new java.util.Date());
                em.persist(aduit);
                em.persist(agencyperms);
                utx.commit();
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form120", new FacesMessage("saved successfully"));
                return "/index.jsp?faces-redirect=true";
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage("abmt_reg_form120", new FacesMessage("insert all the fields"));
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "/index.jsp?faces-redirect=true";
    }

    /**searches the human database for an individuals records using his or her ID*/
    public String searchadmin() {
        human = new Human();
        passport = new DoiDate();
        humanlist2 = em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "'").getResultList();
        try {
            passportlist = em.createQuery("SELECT d FROM DoiDate d WHERE d.identityCardNo =" + searchString).getResultList();
        } catch (Exception e) {
            passport = new DoiDate();
            error = "no passport details";
        }
        return "/searchadmin2.jsp?faces-redirect=true";
    }

    public String admindoubledetails() {
        doubles = (Doubles) doubletable.getRowData();
        try {
            doubles = (Doubles) em.createQuery("SELECT d FROM Doubles d WHERE d.oPid =" + doubles.getOPid()).getSingleResult();
            return "/search_admin.jsp?faces-redirect=true";
        } catch (Exception e) {
            doubles = new Doubles();
            return "/search_admin.jsp?faces-redirect=true";
        }
    }

    public String detail() {
        human = (Human) humantable.getRowData();
        return "/search_admin.jsp?faces-redirect=true";
    }

    public String passportdetail2() {

        passport = (DoiDate) passportable.getRowData();
        try {
            passport = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.identityCardNo=" + passport.getIdentityCardNo()).getSingleResult();
            return "/search_admin.jsp?faces-redirect=true";
        } catch (Exception e) {
            passport = new DoiDate();
            return "/search_admin.jsp?faces-redirect=true";
        }

    }

    public String passportdetails() {
        passport = (DoiDate) passportable.getRowData();
        try {
            passport = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.identityCardNo=" + passport.getIdentityCardNo()).getSingleResult();
            return "/search.jsp?faces-redirect=true";
        } catch (Exception e) {
            passport = new DoiDate();
            return "/search.jsp?faces-redirect=true";
        }
    }

    public String doubledetails() {
        doubles = (Doubles) doubletable.getRowData();
        try {
            doubles = (Doubles) em.createQuery("SELECT d FROM Doubles d WHERE d.oPid =" + doubles.getOPid()).getSingleResult();
            return "/search.jsp?faces-redirect=true";
        } catch (Exception e) {
            doubles = new Doubles();
            return "/search.jsp?faces-redirect=true";
        }

    }

    public String searchByID() {
        human = new Human();
        doubles = new Doubles();
        passport = new DoiDate();
        error = new String();
        Calendar excal1 = Calendar.getInstance();
        Calendar excal2 = Calendar.getInstance();
        excal2.setTime(agencyperms.getExpiryDate());
        System.out.println("found " + agencyperms.getExpiryDate());
        excal1.setTimeInMillis(System.currentTimeMillis());
        try {
            if (excal1.after(excal2)) {
                error = "you need to pay contact administrator for further options ";
                utx.begin();
                agencyperms.setDebt(agencyperms.getInitialpay().toString());
                em.merge(agencyperms);
                utx.commit();
                return "/search.jsp?faces-redirect=true";

            } else {
                if (Integer.parseInt(agencyperms.getInitialpay().toString()) < 0) {
                    error = "you need to pay contact administrator for further options ";
                    utx.begin();
                    agencyperms.setDebt(agencyperms.getInitialpay().toString());
                    em.merge(agencyperms);
                    utx.commit();
                    return "/search.jsp?faces-redirect=true";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/search.jsp?faces-redirect=true";
        }
        if (agencyperms.getTrial().equalsIgnoreCase("yes") && excal1.after(excal2)) {
            error = "your trial period has expired contact administrator to topup ";
        } else {
            if (agencyperms.getTariff().equalsIgnoreCase("pre_paid")) {

                if (agencyperms.getBase().equalsIgnoreCase("per_transaction(fixed)")) {
                    ////check the standing charge and add up to the end of the transactions
                    System.out.println("found" + searchString);
                    BigInteger y = agencyperms.getAmountQueried();
                    BigInteger r = agencyperms.getInitialpay();
                    Integer u = Integer.parseInt(r.toString());
                    Integer o = Integer.parseInt(y.toString());
                    Integer n = u - o;
                    String m = n.toString();
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name" + human.getName());
                        }
                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setInitialpay(new BigInteger(m));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";
                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }
                    }
                } else if (agencyperms.getBase().equalsIgnoreCase("per_transaction(tiered)")) {
                    System.out.println("found" + searchString);
                    BigInteger r = agencyperms.getInitialpay();
                    Integer hit = agencyperms.getHit();
                    System.out.println("the number of hits so far" + agencyperms.getHit());
                    Integer u = Integer.parseInt(r.toString());
                    hits = (Hits) em.createQuery("SELECT h FROM Hits h WHERE h.maximum >=" + hit + " and h.minimum <=" + hit).getSingleResult();
                    Integer o = Integer.parseInt(hits.getValue().toString());
                    Integer n = u - o;
                    String m = n.toString();
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name" + human.getName());
                        }
                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setHit(hit + 1);
                        agencyperms.setInitialpay(new BigInteger(m));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";
                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setHit(hit + 1);
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }
                    }
                } else if (agencyperms.getBase().equalsIgnoreCase("fixed(monthly)")) {
                    BigInteger r = agencyperms.getInitialpay();
                    String m = r.toString();
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name" + human.getName());
                        }
                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setInitialpay(new BigInteger(m));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";

                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }
                    }
                } else {
                    BigInteger r = agencyperms.getInitialpay();
                    Integer hit = agencyperms.getUsers();
                    Integer u = Integer.parseInt(r.toString());
                    rangeusers = (Users) em.createQuery("SELECT u FROM Users u WHERE u.minimum <=" + hit + " and u.maximum >=" + hit).getSingleResult();
                    Integer o = Integer.parseInt(rangeusers.getValue());
                    Integer w = u - o;
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name" + human.getName());
                        }

                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setInitialpay(new BigInteger(w.toString()));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";
                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(w.toString()));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }
                    }
                }
            }
            if (agencyperms.getTariff().equalsIgnoreCase("post_paid")) {
                if (agencyperms.getBase().equalsIgnoreCase("per_transaction(fixed)")) {
                    ////check the standing charge and add up to the end of the transactions
                    System.out.println("found" + searchString);
                    BigInteger y = agencyperms.getAmountQueried();
                    BigInteger r = agencyperms.getInitialpay();
                    Integer u = Integer.parseInt(r.toString());
                    Integer o = Integer.parseInt(y.toString());
                    Integer n = u + o;
                    String m = n.toString();
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name" + human.getName());
                        }

                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setInitialpay(new BigInteger(m));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";
                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }
                    }
                } else if (agencyperms.getBase().equalsIgnoreCase("per_transaction(tiered)")) {
                    System.out.println("found" + searchString);
                    BigInteger r = agencyperms.getInitialpay();
                    hits = (Hits) em.createQuery("SELECT h FROM Hits h WHERE h.maximum >=" + agencyperms.getHit() + " and h.minimum <=" + agencyperms.getHit()).getSingleResult();
                    Integer hit = agencyperms.getHit();
                    Integer hit2 = hit + 1;
                    Integer u = Integer.parseInt(r.toString());
                    Integer o = Integer.parseInt(hits.getValue().toString());
                    Integer n = u + o;
                    String m = n.toString();
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name" + human.getName());
                        }
                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setHit(hit2);
                        agencyperms.setInitialpay(new BigInteger(m));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";

                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setHit(hit2);
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }
                    }
                } else if (agencyperms.getBase().equalsIgnoreCase("fixed(monthly)")) {
                    BigInteger r = agencyperms.getInitialpay();
                    String m = r.toString();
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name" + human.getName());
                        }
                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setInitialpay(new BigInteger(m));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";
                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }

                    }
                } else {
                    ////check the standing charge and add up to the end of the transactions
                    System.out.println("found" + searchString);
                    rangeusers = (Users) em.createQuery("SELECT u FROM Users u WHERE u.minimum <=" + agencyperms.getUsers() + " and u.maximum >=" + agencyperms.getUsers()).getSingleResult();
                    Integer e = Integer.parseInt(agencyperms.getInitialpay().toString()) - Integer.parseInt(rangeusers.getValue());
                    human = new Human();
                    try {
                        if (serial.length() < 0) {
                            human = new Human();
                            error = "serial parameter is empty";
                        } else {
                            docs = (Docums) em.createQuery("SELECT d FROM Docums d WHERE d.serNum =" + serial).getSingleResult();
                            System.out.println(docs.getHuman().getRid());
                            human = (Human) em.createQuery("SELECT h FROM Human h WHERE h.oPid ='" + searchString + "' and h.rid ='" + docs.getHuman().getRid() + "'").getSingleResult();
                            System.out.println("name " + human.getName());
                        }

                        utx.begin();
                        log.setAgencyId(connectusers.getAgencyId());
                        log.setAgencyUser(username);
                        log.setQueryResult(searchString + " is valid");
                        int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                        log.setTid(new BigDecimal(ttid));
                        log.setQueryTime(new java.util.Date());
                        agencyperms.setInitialpay(new BigInteger(e.toString()));
                        em.persist(log);
                        em.merge(agencyperms);
                        utx.commit();
                        return "/search.jsp?faces-redirect=true";
                    } catch (Exception ex) {
                        human = new Human();
                        error = "record not found ";
                        try {
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString + " is invalid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(e.toString()));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();
                            return "/search.jsp?faces-redirect=true";
                        } catch (Exception ex1) {
                            human = new Human();
                            error = "record not found ";
                            return "/search.jsp?faces-redirect=true";
                        }
                    }
                }
            }
        }
        return "/search.jsp?faces-redirect=true";
    }

    public void searchByPassport() {


        error = new String();
        Calendar excal1 = Calendar.getInstance();
        Calendar excal2 = Calendar.getInstance();
        excal2.setTime(agencyperms.getExpiryDate());
        System.out.println("found " + agencyperms.getExpiryDate());
        excal1.setTimeInMillis(System.currentTimeMillis());
        try {
            if (excal1.after(excal2)) {
                error = "you need to pay contact administrator for further options ";
                utx.begin();
                agencyperms.setDebt(agencyperms.getInitialpay().toString());
                em.merge(agencyperms);
                utx.commit();


            } else {
                if (Integer.parseInt(agencyperms.getInitialpay().toString()) < 0) {
                    error = "you need to pay contact administrator for further options ";
                    utx.begin();
                    agencyperms.setDebt(agencyperms.getInitialpay().toString());
                    em.merge(agencyperms);
                    utx.commit();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            if (agencyperms.getTrial().equalsIgnoreCase("yes") && excal1.after(excal2)) {
                error = "your trial period has expired contact administrator to topup ";
            } else {
                if (agencyperms.getTariff().equalsIgnoreCase("pre_paid")) {

                    if (agencyperms.getBase().equalsIgnoreCase("per_transaction(fixed)")) {
                        ////check the standing charge and add up to the end of the transactions
                        System.out.println("found" + searchString);
                        BigInteger y = agencyperms.getAmountQueried();
                        BigInteger r = agencyperms.getInitialpay();
                        Integer u = Integer.parseInt(r.toString());
                        Integer o = Integer.parseInt(y.toString());
                        Integer n = u - o;
                        String m = n.toString();
                        human = new Human();
                        try {

                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception ee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }

                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();

                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setInitialpay(new BigInteger(m));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();

                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }
                        }
                    } else if (agencyperms.getBase().equalsIgnoreCase("per_transaction(tiered)")) {
                        System.out.println("found" + searchString2);
                        BigInteger r = agencyperms.getInitialpay();
                        Integer hit = agencyperms.getHit();
                        System.out.println("the number of hits so far" + agencyperms.getHit());
                        Integer u = Integer.parseInt(r.toString());
                        hits = (Hits) em.createQuery("SELECT h FROM Hits h WHERE h.maximum >=" + hit + " and h.minimum <=" + hit).getSingleResult();
                        Integer o = Integer.parseInt(hits.getValue().toString());
                        Integer n = u - o;
                        String m = n.toString();
                        human = new Human();
                        try {

                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception eee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }

                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setHit(hit + 1);
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();

                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setHit(hit + 1);
                                agencyperms.setInitialpay(new BigInteger(m));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();

                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }
                        }
                    } else if (agencyperms.getBase().equalsIgnoreCase("fixed(monthly)")) {
                        BigInteger r = agencyperms.getInitialpay();
                        String m = r.toString();
                        human = new Human();
                        try {
                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception eee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }

                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();


                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setInitialpay(new BigInteger(m));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();

                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }
                        }
                    } else {
                        BigInteger r = agencyperms.getInitialpay();
                        Integer hit = agencyperms.getUsers();
                        Integer u = Integer.parseInt(r.toString());
                        rangeusers = (Users) em.createQuery("SELECT u FROM Users u WHERE u.minimum <=" + hit + " and u.maximum >=" + hit).getSingleResult();
                        Integer o = Integer.parseInt(rangeusers.getValue());
                        Integer w = u - o;
                        human = new Human();
                        try {
                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception eee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(w.toString()));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();

                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setInitialpay(new BigInteger(w.toString()));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();

                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }
                        }
                    }
                }
                if (agencyperms.getTariff().equalsIgnoreCase("post_paid")) {
                    if (agencyperms.getBase().equalsIgnoreCase("per_transaction(fixed)")) {
                        ////check the standing charge and add up to the end of the transactions
                        System.out.println("found" + searchString2);
                        BigInteger y = agencyperms.getAmountQueried();
                        BigInteger r = agencyperms.getInitialpay();
                        Integer u = Integer.parseInt(r.toString());
                        Integer o = Integer.parseInt(y.toString());
                        Integer n = u + o;
                        String m = n.toString();
                        human = new Human();
                        try {
                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception eee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }

                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();

                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setInitialpay(new BigInteger(m));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();

                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }
                        }
                    } else if (agencyperms.getBase().equalsIgnoreCase("per_transaction(tiered)")) {
                        System.out.println("found" + searchString2);
                        BigInteger r = agencyperms.getInitialpay();
                        hits = (Hits) em.createQuery("SELECT h FROM Hits h WHERE h.maximum >=" + agencyperms.getHit() + " and h.minimum <=" + agencyperms.getHit()).getSingleResult();
                        Integer hit = agencyperms.getHit();
                        Integer hit2 = hit + 1;
                        Integer u = Integer.parseInt(r.toString());
                        Integer o = Integer.parseInt(hits.getValue().toString());
                        Integer n = u + o;
                        String m = n.toString();
                        human = new Human();
                        try {
                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception eee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }
                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setHit(hit2);
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();


                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setHit(hit2);
                                agencyperms.setInitialpay(new BigInteger(m));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();
                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }
                        }
                    } else if (agencyperms.getBase().equalsIgnoreCase("fixed(monthly)")) {
                        BigInteger r = agencyperms.getInitialpay();
                        String m = r.toString();
                        human = new Human();
                        try {
                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception eee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }

                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(m));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();

                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setInitialpay(new BigInteger(m));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();

                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }

                        }
                    } else {
                        ////check the standing charge and add up to the end of the transactions
                        System.out.println("found" + searchString);
                        rangeusers = (Users) em.createQuery("SELECT u FROM Users u WHERE u.minimum <=" + agencyperms.getUsers() + " and u.maximum >=" + agencyperms.getUsers()).getSingleResult();
                        Integer i = Integer.parseInt(agencyperms.getInitialpay().toString()) - Integer.parseInt(rangeusers.getValue());
                        human = new Human();
                        try {
                            try {
                                passport2 = (DoiDate) em.createQuery("SELECT d FROM DoiDate d WHERE d.passportNo = " + passportnumber + "and d.birthYear =" + birthYear).getSingleResult();

                            } catch (Exception eee) {
                                passport2 = new DoiDate();
                                error = "no passport details";
                            }

                            utx.begin();
                            log.setAgencyId(connectusers.getAgencyId());
                            log.setAgencyUser(username);
                            log.setQueryResult(searchString2 + " is valid");
                            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                            log.setTid(new BigDecimal(ttid));
                            log.setQueryTime(new java.util.Date());
                            agencyperms.setInitialpay(new BigInteger(i.toString()));
                            em.persist(log);
                            em.merge(agencyperms);
                            utx.commit();

                        } catch (Exception ex) {
                            human = new Human();
                            error = "record not found ";
                            try {
                                utx.begin();
                                log.setAgencyId(connectusers.getAgencyId());
                                log.setAgencyUser(username);
                                log.setQueryResult(searchString2 + " is invalid");
                                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                                log.setTid(new BigDecimal(ttid));
                                log.setQueryTime(new java.util.Date());
                                agencyperms.setInitialpay(new BigInteger(e.toString()));
                                em.persist(log);
                                em.merge(agencyperms);
                                utx.commit();

                            } catch (Exception ex1) {
                                human = new Human();
                                error = "record not found ";

                            }
                        }
                    }
                }
            }
        }
    }

    /**picks an individual when he /she is selected from the  table*/
    public String returnagency() {
        agencyperms = (AgencyPerms) agencytable.getRowData();
        id = agencyperms.getAgencyId().toString();
        return "/add_users.jsp";
    }

    public String topup() {
        agencyperms = (AgencyPerms) agencytable.getRowData();
        if (agencyperms.getTariff().equalsIgnoreCase("post_paid")) {
            agencyperms.setInitialpay(BigInteger.ZERO);
        }

        return "/topupagency.jsp";
    }

    public String topup2() {
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        c1.add(Calendar.DATE, 30);
        Calendar c2 = Calendar.getInstance();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        c2.add(Calendar.DATE, 90);

        try {
            if (agencyperms.getFrequency().equalsIgnoreCase("monthly")) {
                utx.begin();
                agencyperms.setInitialpay(agencyperms.getInitialpay());
                agencyperms.setDebt("0");
                agencyperms.setExpiryDate(c1.getTime());
                aduit.setAgencyId("IPRS");
                aduit.setAction("topup agency");
                aduit.setUserId(connectusers.getUserid());
                aduit.setTimestamp(new java.util.Date());
                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                aduit.setTid(new BigDecimal(ttid));
                em.persist(aduit);
                em.merge(agencyperms);
                utx.commit();
            } else {
                utx.begin();
                agencyperms.setInitialpay(agencyperms.getInitialpay());
                agencyperms.setDebt("0");
                agencyperms.setExpiryDate(c2.getTime());
                aduit.setAgencyId("IPRS");
                aduit.setAction("topup agency");
                aduit.setUserId(connectusers.getUserid());
                aduit.setTimestamp(new java.util.Date());
                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                aduit.setTid(new BigDecimal(ttid));
                em.persist(aduit);
                em.merge(agencyperms);
                utx.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FacesContext.getCurrentInstance().addMessage("abmt_reg_form1", new FacesMessage("topup succesful"));
        return "/topupagency.jsp";
    }

    /**method to deactivate a user*/
    public void deactivateuser() {
        connectusers = (IconnectUsers) deactivate.getRowData();
        try {
            utx.begin();
            connectusers.setStatus("inactive");
            aduit.setAgencyId("IPRS");
            aduit.setAction("deactivated user");
            aduit.setUserId(connectusers.getUserid());
            aduit.setTimestamp(new java.util.Date());
            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
            aduit.setTid(new BigDecimal(ttid));
            em.persist(aduit);
            em.merge(connectusers);
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        connectusers = (IconnectUsers) em.createQuery("SELECT  i FROM IconnectUsers i WHERE i.password ='" + pass + "'and i.userid ='" + username + "'").getSingleResult();
    }

    /** method to activate the user*/
    public void activateuser() {
        connectusers = (IconnectUsers) deactivate.getRowData();
        try {
            utx.begin();
            connectusers.setStatus("active");
            aduit.setAgencyId("IPRS");
            aduit.setAction("activated agency");
            aduit.setUserId(connectusers.getUserid());
            aduit.setTimestamp(new java.util.Date());
            int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
            aduit.setTid(new BigDecimal(ttid));
            em.persist(aduit);
            em.merge(connectusers);
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        connectusers = (IconnectUsers) em.createQuery("SELECT i FROM IconnectUsers i WHERE i.password ='" + pass + "'and i.userid ='" + username + "'").getSingleResult();
    }

    /**method to register a user under a particular agency*/
    public void adduser() {
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        c1.add(Calendar.DATE, 30);
        Pattern p1 = Pattern.compile("^\\w*(?=\\w*\\d)(?=\\w*[a-z])(?=\\w*[A-Z])\\w*$");
        Matcher m1 = p1.matcher(connectusers1.getPassword());
        boolean matchFound1 = m1.matches();
        if (connectusers1.getPassword().length() < 6 || connectusers1.getPassword().length() > 20) {

            FacesContext.getCurrentInstance().addMessage("abmt_reg_form1", new FacesMessage("Error :your password should be between six and twenty characters"));
        } else if (!matchFound1) {
            FacesContext.getCurrentInstance().addMessage("abmt_reg_form1", new FacesMessage("Error : your password should contain lower and upper case letters and digits"));
        } else {
            try {
                utx.begin();
                connectusers1.setCreateDate(new java.util.Date());
                connectusers1.setExpiryDate(c1.getTime());
                connectusers1.setAgencyId(agencyperms.getAgencyId().toString());
                connectusers1.setEmpId(connectusers1.getEmpId());
                connectusers1.setPassword(connectusers1.getPassword());
                connectusers1.setUserid(connectusers1.getUserid());
                connectusers1.setRoleuser(connectusers1.getRoleuser());
                connectusers1.setStatus("inactive");
                connectusers1.setLogged("0");
                agencyperms.setUsers(agencyperms.getUsers() + 1);
                aduit.setAgencyId("IPRS");
                aduit.setAction("added user under agency " + agencyperms.getAgencyName());
                aduit.setUserId(connectusers.getUserid());
                aduit.setTimestamp(new java.util.Date());
                int ttid = (int) System.currentTimeMillis() % 1000000 * 10000;
                aduit.setTid(new BigDecimal(ttid));
                em.persist(aduit);
                em.persist(connectusers1);
                em.merge(agencyperms);
                utx.commit();
                connectusers1 = new IconnectUsers();
                FacesContext.getCurrentInstance().addMessage("abmt_reg_form1", new FacesMessage("succesfully added"));
                FacesContext.getCurrentInstance().addMessage("form_add_user", new FacesMessage("succesfully added"));
            } catch (Exception o) {
                o.printStackTrace();
            }
        }
    }

    public void paint(OutputStream stream, Object object) throws IOException {
        setImg((IprsImg) em.createQuery("SELECT i FROM IprsImg i WHERE i.rid=" + human.getPhoto()).getSingleResult());
        stream.write(img.getImg());
    }

    public void paint2(OutputStream stream, Object object) throws IOException {
        setImg((IprsImg) em.createQuery("SELECT i FROM IprsImg i WHERE i.rid='" + passport.getPhotograph() + "'").getSingleResult());
        stream.write(img.getImg());
    }

    public void paint4(OutputStream stream, Object object) throws IOException {
        setImg((IprsImg) em.createQuery("SELECT i FROM IprsImg i WHERE i.rid='" + passport2.getPhotograph() + "'").getSingleResult());
        stream.write(img.getImg());
    }

    public void paint3(OutputStream stream, Object object) throws IOException {
        setImg((IprsImg) em.createQuery("SELECT i FROM IprsImg i WHERE i.rid='" + doubles.getPhoto() + "'").getSingleResult());
        stream.write(img.getImg());
    }

    /**the methods below are used to check whether an agency has the rights to view particular fields from the agency permissions table */
    public boolean isPID() {
        System.out.println("found" + agencyperms.getAgencyId());
        return agencyperms.getPid().equals("1") ? true : false;
    }

    public boolean isRID() {
        return agencyperms.getRid().equals("1") ? true : false;
    }

    public boolean isPIN() {
        return agencyperms.getPin().equals("1") ? true : false;
    }

    public boolean isNAME() {
        return agencyperms.getName().equals("1") ? true : false;
    }

    public boolean isSURN() {
        return agencyperms.getSurn().equals("1") ? true : false;
    }

    public boolean isLASTNAME() {
        return agencyperms.getLastName().equals("1") ? true : false;
    }

    public boolean isSEX() {
        return agencyperms.getSex().equals("1") ? true : false;
    }

    public boolean isYEARBIRTH() {
        return agencyperms.getYearBirth().equals("1") ? true : false;
    }

    public boolean isMONTHBIRTH() {
        return agencyperms.getMonthBirth().equals("1") ? true : false;
    }

    public boolean isDAYBIRTH() {
        return agencyperms.getDayBirth().equals("1") ? true : false;
    }

    public boolean isDATEBIRTH() {
        return agencyperms.getDateBirth().equals("1") ? true : false;
    }

    public boolean isYEARDEATH() {
        return agencyperms.getYearDeath().equals("1") ? true : false;
    }

    public boolean isMONTHDEATH() {
        return agencyperms.getMonthDeath().equals("1") ? true : false;
    }

    public boolean isDAYDEATH() {
        return agencyperms.getDayDeath().equals("1") ? true : false;
    }

    public boolean isETHNIC() {
        return agencyperms.getEthnic().equals("1") ? true : false;
    }

    public boolean isCLAN() {
        return agencyperms.getClan().equals("1") ? true : false;
    }

    public boolean isFAMILY() {
        return agencyperms.getFamily().equals("1") ? true : false;
    }

    public boolean isADREFBIRTH() {
        return agencyperms.getAdrrefBirth().equals("1") ? true : false;
    }

    public boolean isADREFLIVE() {
        return agencyperms.getAdrrefLive().equals("1") ? true : false;
    }

    public boolean isADREFDEATH() {
        return agencyperms.getAdrrefDeath().equals("1") ? true : false;
    }

    public boolean isOPID() {
        return agencyperms.getOpid().equals("1") ? true : false;
    }

    public boolean isCITIZ() {
        return agencyperms.getCitiz().equals("1") ? true : false;
    }

    public boolean isFINGER01() {
        return agencyperms.getFinger01().equals("1") ? true : false;
    }

    public boolean isFINGER02() {
        return agencyperms.getFinger02().equals("1") ? true : false;
    }

    public boolean isFINGER03() {
        return agencyperms.getFinger03().equals("1") ? true : false;
    }

    public boolean isFINGER04() {
        return agencyperms.getFinger04().equals("1") ? true : false;
    }

    public boolean isFINGER05() {
        return agencyperms.getFinger05().equals("1") ? true : false;
    }

    public boolean isFINGER06() {
        return agencyperms.getFinger06().equals("1") ? true : false;
    }

    public boolean isFINGER07() {
        return agencyperms.getFinger07().equals("1") ? true : false;
    }

    public boolean isFINGER08() {
        return agencyperms.getFinger08().equals("1") ? true : false;
    }

    public boolean isFINGER09() {
        return agencyperms.getFinger09().equals("1") ? true : false;
    }

    public boolean isFINGER10() {
        return agencyperms.getFinger10().equals("1") ? true : false;
    }

    public boolean isFINGERMAIN() {
        return agencyperms.getFingerMain().equals("1") ? true : false;
    }

    public boolean isPHOTO() {
        return agencyperms.getPhoto().equals("1") ? true : false;
    }

    public boolean isSIGNATURE() {
        return agencyperms.getSignature().equals("1") ? true : false;
    }

    public boolean isDATASCAN() {
        return agencyperms.getDataScan().equals("1") ? true : false;
    }

    public boolean isDATECREATED() {
        return agencyperms.getDateCreated().equals("1") ? true : false;
    }

    public boolean isDATEMODIFIED() {
        return agencyperms.getDateModified().equals("1") ? true : false;

    }

    public boolean isMODIFIEDBY() {

        return agencyperms.getModifiedBy().equals("1") ? true : false;


    }

    public boolean isCREATEDBY() {

        return agencyperms.getCreatedBy().equals("1") ? true : false;

    }

    public boolean isOCUP() {
        return agencyperms.getOccup().equals("1") ? true : false;
    }

    public boolean isDATEDEATH() {
        return agencyperms.getDateDeath().equals("1") ? true : false;
    }

    public AgencyPerms getAgencyperms() {
        return agencyperms;
    }

    /**
     * @param agencyperms the agencyperms to set
     */
    public void setAgencyperms(AgencyPerms agencyperms) {
        this.agencyperms = agencyperms;

    }

    /**
     * @return the connectusers
     */
    public IconnectUsers getConnectusers() {
        return connectusers;

    }

    /**
     * @param connectusers the connectusers to sea t
     */
    public void setConnectusers(IconnectUsers connectusers) {
        this.connectusers = connectusers;

    }

    /**
     * @return the human
     */
    /**
     * @param human the human to set
     */
    public void setHuman(Human human) {
        this.human = human;
    }

    /**
     * @return the log
     */
    public QueryLog getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(QueryLog log) {
        this.log = log;
    }

    /**
     * @return the agencypermlist
     */
    public List<AgencyPerms> getAgencypermlist() {
        agencypermlist = em.createQuery("SELECT a FROM AgencyPerms a order by a.expiryDate desc").getResultList();
        return agencypermlist;

    }

    /**
     * @param agencypermlist the agencypermlist to set
     */
    public void setAgencypermlist(List<AgencyPerms> agencypermlist) {
        this.agencypermlist = agencypermlist;
    }

    /**
     * @return the iconnectuserlist
     */
    public List<IconnectUsers> getIconnectuserlist() {
        iconnectuserlist = em.createQuery("SELECT i FROM IconnectUsers i").getResultList();
        return iconnectuserlist;
    }

    /**
     * @param iconnectuserlist the iconnectuserlist to set
     */
    public void setIconnectuserlist(List<IconnectUsers> iconnectuserlist) {
        this.iconnectuserlist = iconnectuserlist;
    }

    /**
     * @return the humanlist
     */
    public List<Human> getHumanlist() {
        humanlist = em.createQuery("SELECT h FROM Human h").getResultList();
        return humanlist;
    }

    /**
     * @param humanlist the humanlist to set
     */
    public void setHumanlist(List<Human> humanlist) {
        this.humanlist = humanlist;
    }

    /**
     * @return the selectedItems
     */
    public List<String> getSelectedItems() {
        return selectedItems;
    }

    /**
     * @param selectedItems the selectedItems to set
     */
    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    /**
     * @return the agencytable
     */
    public HtmlDataTable getAgencytable() {
        return agencytable;
    }

    /**
     * @param agencytable the agencytable to set
     */
    public void setAgencytable(HtmlDataTable agencytable) {
        this.agencytable = agencytable;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;

    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getSearchString() {
        return searchString;

    }

    /**
     * @param searchString the searchString to set
     */
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Human getHuman() {
        return human;
    }

    /**
     * @return the agencyid
     */
    public String getAgencyid() {
        return agencyid;

    }

    /**
     * @param agencyid the agencyid to set
     */
    public void setAgencyid(String agencyid) {
        this.agencyid = agencyid;

    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;

    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;

    }

    /**
     * @return the loglist
     */
    public List<QueryLog> getLoglist() {
        loglist = em.createQuery("SELECT q FROM QueryLog q").getResultList();

        return loglist;

    }

    /**
     * @param loglist the loglist to set
     */
    public void setLoglist(List<QueryLog> loglist) {
        this.loglist = loglist;

    }

    public String getSearchpassport() {
        return searchpassport;

    }

    /**
     * @param searchpassport the searchpassport to set
     */
    public void setSearchpassport(String searchpassport) {
        this.searchpassport = searchpassport;
    }

    /**
     * @return the searchString2
     */
    public String getSearchString2() {
        return searchString2;

    }

    /**
     * @param searchString2 the searchString2 to set
     */
    public void setSearchString2(String searchString2) {
        this.searchString2 = searchString2;


    }

    /**
     * @return the newpass
     */
    public String getNewpass() {
        return newpass;

    }

    /**
     * @param newpass the newpass to set
     */
    public void setNewpass(String newpass) {
        this.newpass = newpass;

    }

    /**
     * @return the agencyname
     */
    public String getAgencyname() {
        return agencyname;


    }

    /**
     * @param agencyname the agencyname to set
     */
    public void setAgencyname(String agencyname) {
        this.agencyname = agencyname;

    }

    /**
     * @return the confirmpass
     */
    public String getConfirmpass() {
        return confirmpass;
    }

    /**
     * @param confirmpass the confirmpass to set
     */
    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    /**
     * @return the deactivate
     */
    public HtmlDataTable getDeactivate() {
        return deactivate;
    }

    /**
     * @param deactivate the deactivate to set
     */
    public void setDeactivate(HtmlDataTable deactivate) {
        this.deactivate = deactivate;
    }

    /**
     * @return the newusername
     */
    public String getNewusername() {
        return newusername;
    }

    /**
     * @param newusername the newusername to set
     */
    public void setNewusername(String newusername) {
        this.newusername = newusername;
    }

    /**
     * @return the connectusers1
     */
    public IconnectUsers getConnectusers1() {
        return connectusers1;
    }

    /**
     * @param connectusers1 the connectusers1 to set
     */
    public void setConnectusers1(IconnectUsers connectusers1) {
        this.connectusers1 = connectusers1;
    }

    /**
     * @return the img
     */
    public IprsImg getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(IprsImg img) {
        this.img = img;
    }

    /**
     * @return the users
     */
    public String getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(String users) {
        this.users = users;
    }

    /**
     * @return the aduit
     */
    /**
     * @return the auditlist
     */
    /**
     * @return the aduit
     */
    public IprsAudit getAduit() {
        return aduit;
    }

    /**
     * @param aduit the aduit to set
     */
    public void setAduit(IprsAudit aduit) {
        this.aduit = aduit;
    }

    /**
     * @return the auditlist
     */
    public List<IprsAudit> getAuditlist() {
        auditlist = em.createQuery("SELECT i FROM IprsAudit i").getResultList();
        return auditlist;
    }

    /**
     * @param auditlist the auditlist to set
     */
    public void setAuditlist(List<IprsAudit> auditlist) {
        this.auditlist = auditlist;
    }

    /**
     * @return the agencyuserlist
     */
    public List<IconnectUsers> getAgencyuserlist() {
        agencyuserlist = em.createQuery("SELECT i FROM IconnectUsers i WHERE i.agencyId =" + agencyperms.getAgencyId() + "and i.logged=" + '0' + "and i.roleuser ='" + getSub_user() + "'").getResultList();
        return agencyuserlist;
    }

    /**
     * @param agencyuserlist the agencyuserlist to set
     */
    public void setAgencyuserlist(List<IconnectUsers> agencyuserlist) {
        this.agencyuserlist = agencyuserlist;
    }

    /**
     * @return the userloglist
     */
    public List<QueryLog> getUserloglist() {
        userloglist = em.createQuery("SELECT q FROM QueryLog q WHERE q.agencyId =" + agencyperms.getAgencyId()).getResultList();
        return userloglist;
    }

    /**
     * @param userloglist the userloglist to set
     */
    public void setUserloglist(List<QueryLog> userloglist) {
        this.userloglist = userloglist;
    }

    /**
     * @return the sub_user
     */
    public String getSub_user() {
        return sub_user;
    }

    /**
     * @param sub_user the sub_user to set
     */
    public void setSub_user(String sub_user) {
        this.sub_user = sub_user;
    }

    /**
     * @return the docs
     */
    public Docums getDocs() {
        return docs;
    }

    /**
     * @param docs the docs to set
     */
    public void setDocs(Docums docs) {
        this.docs = docs;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * @return the hits
     */
    public Hits getHits() {
        return hits;
    }

    /**
     * @param hits the hits to set
     */
    public void setHits(Hits hits) {
        this.hits = hits;
    }

    /**
     * @return the hitlist
     */
    public List<Hits> getHitlist() {
        hitlist = em.createQuery("SELECT h FROM Hits h").getResultList();
        return hitlist;
    }

    /**
     * @param hitlist the hitlist to set
     */
    public void setHitlist(List<Hits> hitlist) {

        this.hitlist = hitlist;
    }

    /**
     * @return the rangeusers
     */
    public Users getRangeusers() {
        return rangeusers;
    }

    /**
     * @param rangeusers the rangeusers to set
     */
    public void setRangeusers(Users rangeusers) {
        this.rangeusers = rangeusers;
    }

    /**
     * @return the userrangelist
     */
    public List<Users> getUserrangelist() {
        userrangelist = em.createQuery("SELECT u FROM Users u").getResultList();
        return userrangelist;
    }

    /**
     * @param userrangelist the userrangelist to set
     */
    public void setUserrangelist(List<Users> userrangelist) {
        this.userrangelist = userrangelist;
    }

    /**
     * @return the agencyuserlist2
     */
    public List<IconnectUsers> getAgencyuserlist2() {
        agencyuserlist2 = em.createQuery("SELECT i FROM IconnectUsers i WHERE i.agencyId =" + agencyperms.getAgencyId()).getResultList();
        return agencyuserlist2;
    }

    /**
     * @return the humanlist2
     */
    public List<Human> getHumanlist2() {
        return humanlist2;
    }

    /**
     * @param humanlist2 the humanlist2 to set
     */
    public void setHumanlist2(List<Human> humanlist2) {
        this.humanlist2 = humanlist2;
    }

    /**
     * @return the humantable
     */
    public HtmlDataTable getHumantable() {
        return humantable;
    }

    /**
     * @param humantable the humantable to set
     */
    public void setHumantable(HtmlDataTable humantable) {
        this.humantable = humantable;
    }

    /**
     * @param agencyuserlist2 the agencyuserlist2 to set
     */
    public void setAgencyuserlist2(List<IconnectUsers> agencyuserlist2) {
        this.agencyuserlist2 = agencyuserlist2;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the docslist
     */
    public List<Docums> getDocslist() {
        return docslist;
    }

    /**
     * @param docslist the docslist to set
     */
    public void setDocslist(List<Docums> docslist) {
        this.docslist = docslist;
    }

    /**
     * @return the passport
     */
    public DoiDate getPassport() {
        return passport;
    }

    /**
     * @param passport the passport to set
     */
    public void setPassport(DoiDate passport) {
        this.passport = passport;
    }

    /**
     * @return the passportlist
     */
    public List<DoiDate> getPassportlist() {
        return passportlist;
    }

    /**
     * @param passportlist the passportlist to set
     */
    public void setPassportlist(List<DoiDate> passportlist) {
        this.passportlist = passportlist;
    }

    /**
     * @return the passportable
     */
    public HtmlDataTable getPassportable() {
        return passportable;
    }

    /**
     * @param passportable the passportable to set
     */
    public void setPassportable(HtmlDataTable passportable) {
        this.passportable = passportable;
    }

    /**
     * @return the passportnum
     */
    public String getPassportnum() {
        return passportnum;
    }

    /**
     * @param passportnum the passportnum to set
     */
    public void setPassportnum(String passportnum) {
        this.passportnum = passportnum;
    }

    /**
     * @return the doublist
     */
    public List<Doubles> getDoublist() {
        return doublist;
    }

    /**
     * @param doublist the doublist to set
     */
    public void setDoublist(List<Doubles> doublist) {
        this.doublist = doublist;
    }

    /**
     * @return the doubles
     */
    public Doubles getDoubles() {
        return doubles;
    }

    /**
     * @param doubles the doubles to set
     */
    public void setDoubles(Doubles doubles) {
        this.doubles = doubles;
    }

    /**
     * @return the doubletable
     */
    public HtmlDataTable getDoubletable() {
        return doubletable;
    }

    /**
     * @param doubletable the doubletable to set
     */
    public void setDoubletable(HtmlDataTable doubletable) {
        this.doubletable = doubletable;
    }

    /**
     * @return the passport2
     */
    public DoiDate getPassport2() {
        return passport2;
    }

    /**
     * @param passport2 the passport2 to set
     */
    public void setPassport2(DoiDate passport2) {
        this.passport2 = passport2;
    }

    /**
     * @return the birthYear
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * @param birthYear the birthYear to set
     */
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * @return the passportnumber
     */
    public String getPassportnumber() {
        return passportnumber;
    }

    /**
     * @param passportnumber the passportnumber to set
     */
    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    /**
     * @return the acat
     */
    public List<SelectItem> getAcat() {
        List<AgencyCategories> cats = em.createQuery("select ct from AgencyCategories ct").getResultList();
        acat.clear();
        for(AgencyCategories atemp : cats)
        {
            SelectItem si = new SelectItem(atemp.getCategory(), atemp.getCategory());
            acat.add(si);
        }
        return acat;
    }

    /**
     * @param acat the acat to set
     */
    public void setAcat(List<SelectItem> acat) {
        this.acat = acat;
    }

    /**
     * @return the searchlist
     */
    public List<SearchCount> getSearchlist() {
        searchlist = em.createQuery("SELECT a FROM SearchCount a order by a.tid desc").getResultList();
        return searchlist;
    }

    /**
     * @param searchlist the searchlist to set
     */
    public void setSearchlist(List<SearchCount> searchlist) {
        this.searchlist = searchlist;
    }

    /**
     * @return the searchtable
     */
    public HtmlDataTable getSearchtable() {
        return searchtable;
    }

    /**
     * @param searchtable the searchtable to set
     */
    public void setSearchtable(HtmlDataTable searchtable) {
        this.searchtable = searchtable;
    }
}

