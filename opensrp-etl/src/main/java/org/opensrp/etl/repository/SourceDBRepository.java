package org.opensrp.etl.repository;

import java.util.List;

import org.ektorp.ComplexKey;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.opensrp.etl.entity.HouseHold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SourceDBRepository extends CouchDbRepositorySupport<HouseHold> {
	
	@Autowired
	public SourceDBRepository(@Qualifier("sourceDB") CouchDbConnector couchDbConnector) {
		super(HouseHold.class, couchDbConnector);
		initStandardDesignDocument();
	}
	
	@GenerateView
	@Override
	public List<HouseHold> getAll() {
		ViewQuery q = createQuery("all").descending(true).includeDocs(true);
		return db.queryView(q, HouseHold.class);
	}
	
	public ViewResult allData(long timeStamp) {
		ComplexKey start = ComplexKey.of(timeStamp + 1);
		ComplexKey end = ComplexKey.of(Long.MAX_VALUE);
		ViewResult vr = db.queryView(createQuery("all_by_timestamp").startKey(start).endKey(end).descending(false)
		        .includeDocs(false));
		
		return vr;
	}
	
}
