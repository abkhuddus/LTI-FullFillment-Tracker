package com.lti.opportunity.serviceimpl;

public class OpportunityServiceImpl  {

	
/*	Logger logger = LoggerFactory.getLogger(OpportunityService.class);

	@Autowired
	private SequenceIdGenerator sequenceId;

	@Autowired
	private UserMongoRepository userDao;

	@Autowired
	private StatusMangoRepository statusDao;

	@Autowired
	private OpportunityRepository opportunityDao;

	@Override
	public UserStatusCount statusUpdate(String status) {

		UserStatusCount st=statusDao.findById(1).get();

		if(st!=null) {
			if("pending".equals(status)) {
				st.setActive(st.getActive()+1);
				st.setPending(st.getPending()-1);
			}if("blocked".equals(status)) {
				st.setActive(st.getActive()+1);
				st.setBlocked(st.getBlocked()-1);
			}

			UserStatusCount nst=	statusDao.save(st);
			return nst;
		}

		return null;
	}



	@Override
	public String SaveOpportunity(Opportunity op) {

		if(op!=null) {
			op.setId(Long.toString(sequenceId.nextId()));
			//op.setFulfillmentDate(new Date());
			//op.setDate(new Date());
			opportunityDao.save(op);
			return op.getRrNumber()+" "+ "Opportunity saved";
		}
		return null;
	}



	@Override
	public List<Opportunity> getAllOpportunity() {
		return opportunityDao.findAll();

	}

	@Override
	public List<OpStatusDTO> getOpBasedOnStatus() {

		try {
			List<OpStatusDTO>l1=new ArrayList<OpStatusDTO>();
			OpStatusDTO op=new OpStatusDTO();
			Integer open=opportunityDao.getOpenOp("open");
			if(open==null) {
				op.setOpen(0);
			}
			Integer closed=opportunityDao.getclosedOp("close");

			if(closed==null) {
				op.setClosed(0);
			}
			Integer all=(int) opportunityDao.count();
			op.setAll(all);
			op.setClosed(closed);
			op.setOpen(open);
			l1.add(op);
			return l1;
		} catch (Exception e) {

			logger.error("Exception While Fetching count  Opportunities Based On Status");
		}
		return null;

	}


	@Override
	public String UpdateStatusById(UpdateStatus s) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String update(UpdateOpportunityDTO dto) {

		try {

			if(dto!=null) {
				Opportunity op=opportunityDao.findByRrNumber(dto.getRrNumber());

				System.out.println("UPDATE="+op);
				if(op!=null) {
					System.out.println("NOT NULL");
					DateFormat formatter = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
					Date date = null;

					//1
					if(dto.getRemark()!=null) {
						op.setRemarks(dto.getRemark());
						
						System.out.println("remark seted");
					}

					
					 if(dto.getStatus()!=null) {
						 op.setStatus(dto.getStatus());
						 
						 System.out.println("STATUS SET");
					 }
					
					//2
					 System.out.println("YTJ"+dto.getYtj());
					if(dto.getYtj()!=null) {
						
						System.out.println("NOT NULL YTJ");
						try {
							System.out.println("after YTJ FORMATTEED");
							op.setYtj(dto.getYtj());
							System.out.println("YTJ");
						} catch (Exception e) {
                      System.out.println("ERROR IN YTJ");
						}

					}
					
//3
					if(dto.getFulfillmentDate()!=null) {
						try {
							op.setFulfillmentDate(dto.getFulfillmentDate());
							
					LocalDate creaedDate = op.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					LocalDate fillfullDate = op.getFulfillmentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

					
					
					 final long days = ChronoUnit.DAYS.between(creaedDate, fillfullDate);
				   System.out.println("Days between: " + days);
				
				   op.setAgeing(days);
							
						} catch (Exception e) {
							throw new InvalidRequestException("Cannot Understand Date " + e.getMessage());
						}

					}
					
					
					if(dto.getPrimarySkils()!=null) {
						op.setPrimarySkils(dto.getPrimarySkils());
					}
					if(dto.getSecondarySkills()!=null) {
						op.setSecondarySkills(dto.getSecondarySkills());
					}
					
					if(op.getStatus().equals("Open")&& op.getYtj()!=null) {
						op.setSubStatus("YTJ");
					}
					opportunityDao.save(op);
					
					System.out.println("SAVED");
				}
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
*/
}
