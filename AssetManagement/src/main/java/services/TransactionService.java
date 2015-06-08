package services;

import domain.Asset;
import domain.Transaction;

import java.util.List;

/**
 * Created by internship on 8/6/2014.
 */
public interface TransactionService {
	public Transaction getTransactionById(Long id);

	public List<Transaction> getAllTransactions();

	public Long requestAssetByUser(Long idUser, Long idAsset);

	public Asset addAssetToUser(Long idUser, Long idAsset, Long idTransaction);
}
