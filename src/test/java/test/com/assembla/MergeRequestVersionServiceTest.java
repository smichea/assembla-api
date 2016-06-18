package test.com.assembla;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assembla.MergeRequestComment;
import com.assembla.MergeRequestCommentMessage;
import com.assembla.MergeRequestVersion;
import com.assembla.MergeRequestVote;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;
import com.assembla.service.MergeRequestVersionResource;
import com.assembla.service.MergeRequestVersionService;

@RunWith(MockitoJUnitRunner.class)
public class MergeRequestVersionServiceTest extends ServiceTest {

	private MergeRequestVersionResource mrvs;

	@Before
	public void setup() {
		mrvs = new MergeRequestVersionService(this.assemblaClient, TEST_SPACE_ID, 12);
	}

	@Test
	public void mergeRequestVersion() {
		mockGet(new AssemblaResponse(new MergeRequestVersion[50], MergeRequestVersion[].class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/12345/versions.json", MergeRequestVersion[].class);

		int id = 12345;
		List<MergeRequestVersion> versions = mrvs.getAll(id);
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void mergeRequestByVersion() {
		mockGet(new AssemblaResponse(new MergeRequestVersion(), MergeRequestVersion.class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions/1.json", MergeRequestVersion.class);

		MergeRequestVersion version = mrvs.get(500, 1);
		assertNotNull(version);
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void createMergeRequestVersion() {
		mockPost(new AssemblaResponse(new MergeRequestVersion(), MergeRequestVersion.class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions.json");

		MergeRequestVersion version = mrvs.create(500);
		assertNotNull(version);
		verify(super.assemblaClient).post(request);
	}

	@Test
	public void getCommentsForMergeRequestVersion() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions/1/comments.json",
				MergeRequestComment[].class, 1, 25);

		Paging paging = new Paging(1, 25);
		int id = 500;
		int version = 1;
		PagedIterator<MergeRequestComment> comments = mrvs.getComments(id, version, paging);

		assertEquals(request, comments.getRequest());
	}

	@Test
	public void createCommentForMergeRequestVersion() {
		super.mockPost(new AssemblaResponse(new MergeRequestComment(), MergeRequestComment.class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions/1/comments.json",
				MergeRequestComment.class);
		String message = "Test Message";
		request.withBody(new MergeRequestCommentMessage(message));
		int version = 1;
		int id = 500;
		MergeRequestComment response = mrvs.createComment(id, version, message);
		assertNotNull(response);
		verify(super.assemblaClient).post(request);
	}

	@Test
	public void mergeRequestVersionVote() {
		super.mockGet(new AssemblaResponse(new MergeRequestVote[10], MergeRequestVote[].class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions/1/votes.json", MergeRequestVote[].class);
		int version = 1;
		int id = 500;
		List<MergeRequestVote> votes = mrvs.getVotes(id, version);
		verify(assemblaClient).get(request);
	}

	@Test
	public void mergeRequestVersionVoteUp() {
		mockPost(new AssemblaResponse(new MergeRequestVote(), MergeRequestVote.class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions/1/votes/upvote.json", MergeRequestVote.class);

		int id = 500;
		int version = 1;
		MergeRequestVote vote = mrvs.upvote(id, version);
		verify(assemblaClient).post(request);
	}

	@Test
	public void mergeRequestVersionVoteDown() {
		mockPost(new AssemblaResponse(new MergeRequestVote(), MergeRequestVote.class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions/1/votes/downvote.json", MergeRequestVote.class);

		int id = 500;
		int version = 1;
		MergeRequestVote vote = mrvs.downvote(id, version);
		verify(assemblaClient).post(request);
	}

	@Test
	public void mergeRequestVersionVoteDelete() {
		mockPost(new AssemblaResponse(new MergeRequestVote(), MergeRequestVote.class));
		AssemblaRequest request = new AssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/500/versions/1/votes/delete.json", MergeRequestVote.class);

		int id = 500;
		int version = 1;
		MergeRequestVote vote = mrvs.delete(id, version);
		verify(assemblaClient).post(request);
	}

}
